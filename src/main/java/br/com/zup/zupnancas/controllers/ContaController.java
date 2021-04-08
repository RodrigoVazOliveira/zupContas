package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dto.conta.CadastrarContaDTO;
import br.com.zup.zupnancas.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contas/")
public class ContaController {

    private ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastrarContaDTO gravarNovaConta(@RequestBody @Valid CadastrarContaDTO cadastrarContaDTO) {

    }
}
