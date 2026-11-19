
package br.com.obrasegura.model;

import java.time.LocalDateTime;

public class SensorMovimento extends Sensor {

    private double aceleracaoX;
    private double aceleracaoY;
    private double aceleracaoZ;
    private boolean movimentoAnormal;

    public SensorMovimento() {
    }

    public SensorMovimento(Long idSensor, Long idObra,
                           String identificacao, String localizacao,
                           String status, LocalDateTime dataInstalacao,
                           double aceleracaoX, double aceleracaoY,
                           double aceleracaoZ, boolean movimentoAnormal) {

        super(idSensor, idObra, identificacao, "MOVIMENTO",
                localizacao, status, dataInstalacao);

        this.aceleracaoX = aceleracaoX;
        this.aceleracaoY = aceleracaoY;
        this.aceleracaoZ = aceleracaoZ;
        this.movimentoAnormal = movimentoAnormal;
    }

    @Override
    public String capturarLeitura() {
        return "Aceleração X: " + aceleracaoX
                + " | Y: " + aceleracaoY
                + " | Z: " + aceleracaoZ
                + " | Movimento anormal: " + movimentoAnormal;
    }

    public double getAceleracaoX() {
        return aceleracaoX;
    }

    public void setAceleracaoX(double aceleracaoX) {
        this.aceleracaoX = aceleracaoX;
    }

    public double getAceleracaoY() {
        return aceleracaoY;
    }

    public void setAceleracaoY(double aceleracaoY) {
        this.aceleracaoY = aceleracaoY;
    }

    public double getAceleracaoZ() {
        return aceleracaoZ;
    }

    public void setAceleracaoZ(double aceleracaoZ) {
        this.aceleracaoZ = aceleracaoZ;
    }

    public boolean isMovimentoAnormal() {
        return movimentoAnormal;
    }

    public void setMovimentoAnormal(boolean movimentoAnormal) {
        this.movimentoAnormal = movimentoAnormal;
    }
}
