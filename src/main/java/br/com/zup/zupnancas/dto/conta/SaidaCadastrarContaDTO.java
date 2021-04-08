package br.com.zup.zupnancas.dto.conta;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.models.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaidaCadastrarContaDTO {

    private Integer id;
    private Double valor;
    private String descricacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;
    private Status status;

    public SaidaCadastrarContaDTO() {
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

    public static SaidaCadastrarContaDTO converterContaParaSaidaCadastrarContaDTO(Conta conta) {
        SaidaCadastrarContaDTO dto = new SaidaCadastrarContaDTO();
        dto.setId(conta.getId());
        dto.setValor(conta.getValor());
        dto.setDescricacao(conta.getDescricao());
        dto.setStatus(conta.getStatus());
        dto.setDataDeSaida(conta.getDataDeSaida());
        dto.setDataDeVencimento(conta.getDataDeVencimento());
        return dto;
    }

    public static Iterable<SaidaCadastrarContaDTO> converterListaContaParaListContaDto(Iterable<Conta> contas) {
        List<SaidaCadastrarContaDTO> dtos = new ArrayList<>();
        for (Conta conta : contas) {
            dtos.add(converterContaParaSaidaCadastrarContaDTO(conta));
        }

        return dtos;
    }
}
