// =========================================
// OBRASEGURA - DASHBOARD
// =========================================

async function carregarDashboard() {
    try {
        const resposta = await fetch("/api/monitoramento");

        if (!resposta.ok) {
            throw new Error("Erro ao consultar monitoramento.");
        }

        const dados = await resposta.json();

        if (!dados || dados.length === 0) {
            console.warn("Nenhum dado de monitoramento encontrado.");
            return;
        }

        atualizarIndicadores(dados);
        atualizarObra(dados[0]);
        atualizarSensor(dados[0]);
        atualizarAtividade(dados[0]);
        atualizarAlertas(dados);

        const ultimaAtualizacao = document.getElementById("ultimaAtualizacao");

        if (ultimaAtualizacao) {
            ultimaAtualizacao.textContent =
                "Última atualização: " +
                new Date().toLocaleTimeString("pt-BR");
        }

    } catch (erro) {
        console.error("Erro ao carregar dashboard:", erro);
    }
}


// =========================================
// INDICADORES
// =========================================

function atualizarIndicadores(dados) {

    const obras = new Set(dados.map(item => item.obra));
    const sensores = new Set(dados.map(item => item.sensor));
    const atividades = new Set(dados.map(item => item.atividade));

    const alertasPendentes = dados.filter(
        item => item.statusAlerta === "AGUARDANDO_VERIFICACAO"
    );

    document.getElementById("totalObras").textContent = obras.size;
    document.getElementById("totalSensores").textContent = sensores.size;
    document.getElementById("totalAlertas").textContent =
        alertasPendentes.length;
    document.getElementById("totalAtividades").textContent =
        atividades.size;
}


// =========================================
// OBRA
// =========================================

function atualizarObra(dado) {

    document.getElementById("nomeObra").textContent =
        dado.obra || "--";

    document.getElementById("localObra").textContent =
        "📍 " + (dado.cidade || "--") + "/" + (dado.estado || "--");
}


// =========================================
// SENSOR
// =========================================

function atualizarSensor(dado) {

    document.getElementById("nomeSensor").textContent =
        dado.sensor || "--";

    document.getElementById("tipoSensor").textContent =
        dado.tipoSensor || "--";

    document.getElementById("statusSensor").textContent =
        "● " + (dado.statusSensor || "ATIVO");

    document.getElementById("localSensor").textContent =
        dado.localSensor || "--";

    document.getElementById("obraSensor").textContent =
        dado.obra || "--";

    document.getElementById("valorLeitura").textContent =
        (dado.valorLeitura ?? "--") + " " + (dado.unidade || "");

    document.getElementById("descricaoLeitura").textContent =
        dado.leitura || "--";

    document.getElementById("statusAlerta").textContent =
        formatarStatus(dado.statusAlerta);
}


// =========================================
// ATIVIDADE
// =========================================

function atualizarAtividade(dado) {

    document.getElementById("nomeAtividade").textContent =
        dado.atividade || "--";

    document.getElementById("descricaoAtividade").textContent =
        dado.tituloAlerta || "Monitoramento de segurança";
}


// =========================================
// ALERTAS
// =========================================

function atualizarAlertas(dados) {

    const container = document.getElementById("listaAlertas");

    const alertas = [...dados].sort((a, b) => {
        return new Date(b.dataHora) - new Date(a.dataHora);
    });

    if (alertas.length === 0) {

        container.innerHTML = `
            <p class="loading-message">
                Nenhum alerta registrado.
            </p>
        `;

        return;
    }

    container.innerHTML = alertas.map(alerta => {

        const status = formatarStatus(alerta.statusAlerta);
        const classe = classeStatus(alerta.statusAlerta);

        const data = alerta.dataHora
            ? new Date(alerta.dataHora).toLocaleString("pt-BR")
            : "--";

        const botaoVerificar =
            alerta.statusAlerta === "AGUARDANDO_VERIFICACAO"
                ? `
                    <button
                        class="verify-button"
                        onclick="verificarAlerta(${alerta.idAlerta})">
                        ✓ Verificar alerta
                    </button>
                `
                : "";

        return `
            <div class="alert-item">

                <div class="alert-icon">
                    🚨
                </div>

                <div class="alert-info">

                    <strong>
                        ${alerta.tituloAlerta || "Alerta de segurança"}
                    </strong>

                    <p>
                        ${alerta.descricaoAlerta || ""}
                    </p>

                    <span class="alert-date">
                        ${data}
                    </span>

                    <div class="alert-actions">

                        <span class="alert-status ${classe}">
                            ${status}
                        </span>

                        ${botaoVerificar}

                    </div>

                </div>

            </div>
        `;

    }).join("");
}


// =========================================
// FORMATAR STATUS
// =========================================

function formatarStatus(status) {

    switch (status) {

        case "AGUARDANDO_VERIFICACAO":
            return "AGUARDANDO VERIFICAÇÃO";

        case "VERIFICADO":
            return "VERIFICADO";

        case "RESOLVIDO":
            return "RESOLVIDO";

        default:
            return status || "--";
    }
}


// =========================================
// CLASSE CSS DO STATUS
// =========================================

function classeStatus(status) {

    switch (status) {

        case "AGUARDANDO_VERIFICACAO":
            return "pendente";

        case "VERIFICADO":
            return "verificado";

        case "RESOLVIDO":
            return "resolvido";

        default:
            return "";
    }
}


// =========================================
// VERIFICAR ALERTA
// =========================================

async function verificarAlerta(id) {

    const confirmar = confirm(
        "Confirma que este alerta foi verificado por um responsável?"
    );

    if (!confirmar) {
        return;
    }

    try {

        const resposta = await fetch(
            `/api/alertas/${id}/verificar`,
            {
                method: "PUT"
            }
        );

        const mensagem = await resposta.text();

        if (!resposta.ok) {
            throw new Error(mensagem || "Erro ao verificar alerta.");
        }

        alert("Alerta verificado com sucesso!");

        await carregarDashboard();

    } catch (erro) {

        console.error(erro);

        alert(
            "Não foi possível verificar o alerta: " +
            erro.message
        );
    }
}


// =========================================
// SIMULAR OCORRÊNCIA
// =========================================

async function simularOcorrencia() {

    const botao = document.getElementById("btnSimularOcorrencia");

    if (botao) {
        botao.disabled = true;
        botao.textContent = "⏳ Simulando ocorrência...";
    }

    try {

        const resposta = await fetch(
            "/api/simulacao/movimento",
            {
                method: "POST"
            }
        );

        const mensagem = await resposta.text();

        if (!resposta.ok) {
            throw new Error(mensagem || "Erro ao simular ocorrência.");
        }

        alert(mensagem);

        await carregarDashboard();

    } catch (erro) {

        console.error("Erro na simulação:", erro);

        alert(
            "Não foi possível simular a ocorrência.\n\n" +
            erro.message
        );

    } finally {

        if (botao) {
            botao.disabled = false;
            botao.textContent = "🚨 Simular ocorrência";
        }
    }
}


// =========================================
// CARREGAMENTO INICIAL
// =========================================

carregarDashboard();


// =========================================
// ATUALIZAÇÃO AUTOMÁTICA
// A CADA 30 SEGUNDOS
// =========================================

setInterval(carregarDashboard, 30000);