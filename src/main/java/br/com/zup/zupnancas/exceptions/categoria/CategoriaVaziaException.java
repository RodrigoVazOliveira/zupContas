package br.com.zup.zupnancas.exceptions.categoria;

public class CategoriaVaziaException extends RuntimeException {
    private Integer status = 200;
    private String descricaoStatus = "OK";
    private String tipoDeErro = "Nenhuma categoria cadastrada!";

    public CategoriaVaziaException(String message) {
        super(message);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }
}
