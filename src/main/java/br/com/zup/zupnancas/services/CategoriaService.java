package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria gravarNovaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria pesquisarCategoriaPorId(Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoria.getId());
        if (optionalCategoria.isEmpty()) {
            throw new RuntimeException("Categoria com id  " + categoria.getId() + " não localizada!");
        }
        return optionalCategoria.get();
    }

    public Iterable<Categoria> obterTodasCategorias() {
        return categoriaRepository.findAll();
    }
}
