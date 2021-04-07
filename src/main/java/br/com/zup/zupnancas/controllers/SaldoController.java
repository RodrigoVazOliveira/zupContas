package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("saldos/")
public class SaldoController {

    private final SaldoService saldoService;

    @Autowired
    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }
}
