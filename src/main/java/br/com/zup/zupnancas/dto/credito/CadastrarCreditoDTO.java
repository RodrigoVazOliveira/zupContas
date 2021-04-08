package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CadastrarCreditoDTO {

    @NotNull(message = "O campo valor não foi informado")
    @NotEmpty(message = "O valor está vazio!")
    private Double valor;

    @NotNull(message = "O campo descricacao não foi informado")
    @NotEmpty(message = "O descricacao está vazio!")
    private String descricacao;

    @NotNull(message = "O campo cpf não foi informado")
    @NotEmpty(message = "O cpf está vazio!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    public CadastrarCreditoDTO() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Credito converterCadastrarCreditoDtoParaCredito() {
        Credito credito = new Credito();
        credito.setValor(this.valor);
        credito.setDescricacao(this.descricacao);
        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);
        credito.setSaldo(saldo);
        return credito;
    }
}
