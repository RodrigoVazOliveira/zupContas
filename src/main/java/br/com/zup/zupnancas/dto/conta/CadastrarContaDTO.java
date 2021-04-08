package br.com.zup.zupnancas.dto.conta;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.models.Saldo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastrarContaDTO {

    @NotNull(message = "O campo valor não foi informado!")
    private Double valor;

    @NotNull(message = "O campo descricacao não foi informado!")
    @NotEmpty(message = "O campo descricacao está vazio!")
    @NotBlank(message = "O campo descricacao está em branco!")
    private String descricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;

    @NotNull(message = "O campo status não foi informado!")
    @NotEmpty(message = "O campo status está vazio!")
    @NotBlank(message = "O campo status está em branco!")
    private Status status;

    @NotNull(message = "O campo cpf não foi informado!")
    @NotEmpty(message = "O campo cpf está vazio!")
    @NotBlank(message = "O campo cpf está em branco!")
    @CPF(message = "O CPF informado é invalido!")
    private String cpf;

    public CadastrarContaDTO() {
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

    public LocalDate getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(LocalDate dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta converterCadastrarContaDtoParaConta() {
        Conta conta = new Conta();
        conta.setValor(this.valor);
        conta.setDescricao(this.descricacao);
        conta.setDataDeSaida(this.dataDeSaida);
        conta.setDataDeVencimento(this.dataDeVencimento);

        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);

        conta.setSaldo(saldo);

        conta.setStatus(this.status);

        return conta;
    }
}
