package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dto.credito.CadastrarCreditoDTO;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.nio.file.ReadOnlyFileSystemException;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    private final CreditoService creditoService;

    @Autowired
    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping
    public Credito adicionarNovoCredito(@RequestBody @Valid CadastrarCreditoDTO cadastrarCreditoDTO) {
        try {
            return creditoService.adicionarNovoCredito(cadastrarCreditoDTO.converterCadastrarCreditoDtoParaCredito());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage())
        }
    }
}
