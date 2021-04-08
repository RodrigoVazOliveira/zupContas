package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    private final SaldoRepository saldoRepository;

    @Autowired
    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Saldo gravarNovoSaldo(Saldo saldo) {
        return saldoRepository.save(saldo);
    }

    public void creditarSaldo(Credito credito) {
        Optional<Saldo> optionalSaldo = saldoRepository.findById(credito.getSaldo().getCpf());

        if (optionalSaldo.isEmpty()) {
            throw new RuntimeException("Não existe saldo com o CPF " + credito.getSaldo().getCpf());
        }

        Saldo saldo = optionalSaldo.get();
        Double valorAtualizado = saldo.getValor() + credito.getValor();
        saldo.setValor(valorAtualizado);

        saldoRepository.save(saldo);
    }
}
