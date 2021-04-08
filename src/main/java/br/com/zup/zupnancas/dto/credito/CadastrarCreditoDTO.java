package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;

public class CadastrarCreditoDTO {
    private Double valor;
    private String descricacao;
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
