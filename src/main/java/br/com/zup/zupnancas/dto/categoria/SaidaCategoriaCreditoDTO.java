package br.com.zup.zupnancas.dto.categoria;

import br.com.zup.zupnancas.models.Categoria;

public class SaidaCategoriaCreditoDTO {
    private String nome;

    public SaidaCategoriaCreditoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static SaidaCategoriaCreditoDTO converterModelParaDto(Categoria categoria) {
        SaidaCategoriaCreditoDTO dto = new SaidaCategoriaCreditoDTO();
        dto.setNome(categoria.getNome());
        return dto;
    }
}
