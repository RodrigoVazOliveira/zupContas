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
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;
    private Status status;
    private String cpf;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public static SaidaCadastrarContaDTO converterContaParaSaidaCadastrarContaDTO(Conta conta) {
        SaidaCadastrarContaDTO dto = new SaidaCadastrarContaDTO();
        dto.setId(conta.getId());
        dto.setValor(conta.getValor());
        dto.setDescricao(conta.getDescricao());
        dto.setStatus(conta.getStatus());
        dto.setDataDeSaida(conta.getDataDeSaida());
        dto.setDataDeVencimento(conta.getDataDeVencimento());
        dto.setCpf(conta.getSaldo().getCpf());
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
