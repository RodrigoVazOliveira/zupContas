package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dto.categoria.CadastrarCategoriaDTO;
import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria gravarNovaCategoria(@RequestBody @Valid CadastrarCategoriaDTO cadastrarCategoriaDTO) {
        return categoriaService.gravarNovaCategoria(
                cadastrarCategoriaDTO.converterCadastrarCategoriaDtoParaCategoria()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Categoria> visualizarTodasCategorias() {
        return categoriaService.obterTodasCategorias();
    }
}
