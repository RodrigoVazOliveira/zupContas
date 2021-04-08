package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.models.Credito;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class SaidaCadastrarCreditoDTO {
    private Integer id;
    private Double valor;
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        saidaCadastrarCreditoDTO.setDescricao(credito.getDescricao());
        saidaCadastrarCreditoDTO.setDataDeEntrada(credito.getDataDeEntrada());
        return saidaCadastrarCreditoDTO;
    }
}
