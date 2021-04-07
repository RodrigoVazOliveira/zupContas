package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

    private final SaldoRepository saldoRepository;

    @Autowired
    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }
}
