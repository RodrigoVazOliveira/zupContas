package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CadastrarCreditoDTO {

    @NotNull(message = "O campo valor não foi informado")
    private Double valor;

    @NotNull(message = "O campo descricacao não foi informado")
    @NotEmpty(message = "O descricacao está vazio!")
    private String descricao;

    @NotNull(message = "O campo cpf não foi informado")
    @NotEmpty(message = "O cpf está vazio!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    private List<Categoria> categorias;

    public CadastrarCreditoDTO() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Credito converterCadastrarCreditoDtoParaCredito() {
        Credito credito = new Credito();
        credito.setValor(this.valor);
        credito.setDescricao(this.descricao);
        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);
        credito.setSaldo(saldo);
        credito.setCategorias(this.categorias);
        return credito;
    }
}
