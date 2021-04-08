package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }
}
