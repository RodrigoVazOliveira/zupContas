package br.com.zup.zupnancas.dto.credito;

import br.com.zup.zupnancas.dto.categoria.SaidaCategoriaCreditoDTO;
import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.models.Credito;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaidaCadastrarCreditoDTO {
    private Integer id;
    private Double valor;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeEntrada;
    private List<SaidaCategoriaCreditoDTO> categorias;

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

    public List<SaidaCategoriaCreditoDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<SaidaCategoriaCreditoDTO> categorias) {
        this.categorias = categorias;
    }

    public static SaidaCadastrarCreditoDTO converterCreditoParaSaidaCadastrarCredito(Credito credito) {
        SaidaCadastrarCreditoDTO dto = new SaidaCadastrarCreditoDTO();
        dto.setId(credito.getId());
        dto.setValor(credito.getValor());
        dto.setDescricao(credito.getDescricao());
        dto.setDataDeEntrada(credito.getDataDeEntrada());
        dto.setCategorias(converterCategoriasParaCategoriasDto(credito.getCategoria()));
        return dto;
    }

    private static List<SaidaCategoriaCreditoDTO> converterCategoriasParaCategoriasDto(List<Categoria> categorias) {
        List<SaidaCategoriaCreditoDTO> categoriasDto = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasDto.add(SaidaCategoriaCreditoDTO.converterModelParaDto(categoria));
        }
        return categoriasDto;
    }

    public   static Iterable<SaidaCadastrarCreditoDTO> converterListaCreditoParaListaCreditoDto(Iterable<Credito> creditos) {
        List<SaidaCadastrarCreditoDTO> dtos = new ArrayList<>();
        for (Credito credito : creditos ) {
            dtos.add(converterCreditoParaSaidaCadastrarCredito(credito));
        }
        return dtos;
    }
}
