package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.credito.CreditoSemCadastroException;
import br.com.zup.zupnancas.exceptions.credito.PesquisarCreditoPorNomeDeCategoriaException;
import br.com.zup.zupnancas.models.Categoria;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;
    private final SaldoService saldoService;
    private final CategoriaService categoriaService;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository,
                          SaldoService saldoService,
                          CategoriaService categoriaService) {
        this.creditoRepository = creditoRepository;
        this.saldoService = saldoService;
        this.categoriaService = categoriaService;
    }

    public Credito adicionarNovoCredito(Credito credito) {
        credito.setDataDeEntrada(LocalDate.now());
        cadastrarCategorias(credito.getCategorias());
        Credito novoCredito = creditoRepository.save(credito);
        saldoService.creditarSaldo(novoCredito);
        return novoCredito;
    }

    private void cadastrarCategorias(List<Categoria> categorias) {
        List<Categoria> categoriasCadastradas = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (categoria.getId() == null) {
                categoriasCadastradas.add(categoriaService.gravarNovaCategoria(categoria));
            } else {
                categoriasCadastradas.add(
                        categoriaService.pesquisarCategoriaPorId(categoria)
                );
            }
        }
        categorias = categoriasCadastradas;
    }

    public Iterable<Credito> obterTodosOsCreditos() {
        if (creditoRepository.count() == 0) {
            throw new CreditoSemCadastroException("Nenhum crédito foi localizado!");
        }
        return creditoRepository.findAll();
    }

    public Iterable<Credito> obterTodosOsCreditosPorNomeDaCategoria(String nome) {
        List<Credito> creditos = (List<Credito>) creditoRepository.findByCategoriasNome(nome);
        if (creditos.size() == 0) {
            throw new PesquisarCreditoPorNomeDeCategoriaException(
                    "nenhum crédito com localizado com as seguintes categorias " + nome);
        }
        return creditoRepository.findByCategoriasNome(nome);
    }
}
