package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;
    private final SaldoService saldoService;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository, SaldoService saldoService) {
        this.creditoRepository = creditoRepository;
        this.saldoService = saldoService;
    }

    public Credito adicionarNovoCredito(Credito credito) {
        credito.setDataDeEntrada(LocalDate.now());
        Credito novoCredito = creditoRepository.save(credito);
        saldoService.creditarSaldo(novoCredito);
        return novoCredito;
    }
}
