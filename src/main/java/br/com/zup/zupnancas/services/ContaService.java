package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.exceptions.conta.CadastroDeContaException;
import br.com.zup.zupnancas.exceptions.conta.PesquisarContaPorIdException;
import br.com.zup.zupnancas.exceptions.conta.PesquisarContaPorStatusException;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final SaldoService saldoService;

    @Autowired
    public ContaService(ContaRepository contaRepository, SaldoService saldoService) {
        this.contaRepository = contaRepository;
        this.saldoService = saldoService;
    }

    public Conta gravarNovaConta(Conta conta) {
        verificarStatus(conta.getStatus());
        return contaRepository.save(conta);
    }

    public void verificarStatus(Status status) {
        if (status.equals(Status.PAGO)) {
            throw new CadastroDeContaException("O status deve ser apenas ARGUARDANDO OU ATRASADO!");
        }
    }

    public Conta pesquisarContaPorId(Conta conta) {
        Optional<Conta> optionalConta = contaRepository.findById(conta.getId());

        if (optionalConta.isEmpty()) {
            throw new PesquisarContaPorIdException("Conta não localizada");
        }

        return optionalConta.get();
    }

    public Conta atualizarConta(Conta conta) {
        Conta contaAntiga = pesquisarContaPorId(conta);

        if (atualizarValorNoSaldo(contaAntiga)) {
            contaAntiga.setStatus(conta.getStatus());
            return contaRepository.save(contaAntiga);
        }

        return contaAntiga;
    }

    private Boolean atualizarValorNoSaldo(Conta conta) {
        return saldoService.debitarConta(conta);
    }

    public Iterable<Conta> pesquisarContaPorStatus(Status status) {
        List<Conta> contas = (List<Conta>) contaRepository.findByStatus(status);
        if (contas.size() == 0) {
            throw new PesquisarContaPorStatusException("Nenhuma conta foi localizada com status" + status.toString());
        }
        return contas;
    }
}
