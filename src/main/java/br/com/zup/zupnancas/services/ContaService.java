package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException("O status deve ser apenas ARGUARDANDO OU ATRASADO!");
        }
    }

    public Conta pesquisarContaPorId(Conta conta) {
        Optional<Conta> optionalConta = contaRepository.findById(conta.getId());

        if (optionalConta.isEmpty()) {
            throw new RuntimeException("Conta não localizada");
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
}
