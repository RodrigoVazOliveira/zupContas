package br.com.zup.zupnancas.dto.conta;

import br.com.zup.zupnancas.enumerates.Status;

import javax.validation.constraints.NotNull;

public class AtualizarContaDTO {

    @NotNull(message = "O campo id não foi informado")
    private Integer id;

    @NotNull(message = "O campo status não foi informado")
    private Status status;

    public AtualizarContaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
