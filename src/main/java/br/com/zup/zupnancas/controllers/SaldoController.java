package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dto.saldo.CadastrarSaldoDTO;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("saldos/")
public class SaldoController {

    private final SaldoService saldoService;

    @Autowired
    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saldo gravarNovoSaldo(@RequestBody @Valid CadastrarSaldoDTO cadastrarSaldoDTO) {
        return saldoService.gravarNovoSaldo(cadastrarSaldoDTO.converterSaldoDTOParaSaldo());
    }
}
