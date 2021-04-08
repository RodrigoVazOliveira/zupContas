package br.com.zup.zupnancas.dto.categoria;

import br.com.zup.zupnancas.models.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CadastrarCategoriaDTO {

    @NotNull(message = "O campo nome não foi informado!")
    @NotEmpty(message = "O campo nome está vazio!")
    @NotBlank(message = "O campo nome está em branco")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converterCadastrarCategoriaDtoParaCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome(this.nome);
        return categoria;
    }
}
