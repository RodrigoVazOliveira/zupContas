package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.models.Credito;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class SaidaCadastrarCreditoDTO {
    private Integer id;
    private Double valor;
    private String descricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeEntrada;

    public SaidaCadastrarCreditoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public static SaidaCadastrarCreditoDTO converterCreditoParaSaidaCadastrarCredito(Credito credito) {
        SaidaCadastrarCreditoDTO saidaCadastrarCreditoDTO = new SaidaCadastrarCreditoDTO();
        saidaCadastrarCreditoDTO.setId(credito.getId());
        saidaCadastrarCreditoDTO.setValor(credito.getValor());
        saidaCadastrarCreditoDTO.setDescricacao(credito.getDescricacao());
        saidaCadastrarCreditoDTO.setDataDeEntrada(credito.getDataDeEntrada());
        return saidaCadastrarCreditoDTO;
    }
}
