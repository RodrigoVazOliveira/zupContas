package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.categoria.CategoriaVaziaException;
import br.com.zup.zupnancas.exceptions.categoria.PesquisarCategoriaPorIdException;
import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria gravarNovaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria pesquisarCategoriaPorId(Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoria.getId());
        if (optionalCategoria.isEmpty()) {
            throw new PesquisarCategoriaPorIdException("Categoria com id " + categoria.getId() + " não localizada!");
        }
        return optionalCategoria.get();
    }

    public Iterable<Categoria> obterTodasCategorias() {
        if (categoriaRepository.count() == 0) {
            throw new CategoriaVaziaException("Nenhuma categoria foi localizada!");
        }

        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Categoria categoria) {
        Categoria categoriaGravada = pesquisarCategoriaPorId(categoria);
        categoriaRepository.delete(categoriaGravada);
    }

    public void deletarCategoria(Integer id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        deletarCategoria(categoria);
    }
}
