package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria gravarNovaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> obterTodasCategorias() {
        return categoriaRepository.findAll();
    }
}
