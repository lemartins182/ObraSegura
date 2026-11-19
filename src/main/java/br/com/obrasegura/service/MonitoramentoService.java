
package br.com.obrasegura.service;

import br.com.obrasegura.model.Alerta;
import br.com.obrasegura.model.SensorMovimento;

import java.time.LocalDateTime;

public class MonitoramentoService {

    public Alerta analisarMovimento(SensorMovimento sensor) {

        if (sensor == null) {
            return null;
        }

        if (sensor.isMovimentoAnormal()) {

            return new Alerta(
                    null,
                    sensor.getIdObra(),
                    sensor.getIdSensor(),
                    "Movimentação anormal detectada",
                    "Foi identificada uma movimentação atípica em "
                            + sensor.getLocalizacao()
                            + ". É necessária verificação humana.",
                    "ATENCAO",
                    "AGUARDANDO_VERIFICACAO",
                    LocalDateTime.now()
            );
        }

        return null;
    }
}
