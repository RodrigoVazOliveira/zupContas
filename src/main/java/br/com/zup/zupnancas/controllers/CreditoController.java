package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dto.credito.CadastrarCreditoDTO;
import br.com.zup.zupnancas.dto.credito.SaidaCadastrarCreditoDTO;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    private final CreditoService creditoService;

    @Autowired
    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastrarCreditoDTO adicionarNovoCredito(@RequestBody @Valid CadastrarCreditoDTO cadastrarCreditoDTO) {
        Credito credito = creditoService.adicionarNovoCredito(cadastrarCreditoDTO.converterCadastrarCreditoDtoParaCredito());
        return SaidaCadastrarCreditoDTO.converterCreditoParaSaidaCadastrarCredito(credito);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<SaidaCadastrarCreditoDTO> visualizarTodosCreditos() {
        return SaidaCadastrarCreditoDTO.converterListaCreditoParaListaCreditoDto(
                creditoService.obterTodosOsCreditos()
        );
    }

    @GetMapping("categorias")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<SaidaCadastrarCreditoDTO> visualizartodosCreditosPorNomeDeCategoria(
            @RequestParam(name = "nome")  String nome) {
        return  SaidaCadastrarCreditoDTO.converterListaCreditoParaListaCreditoDto(
                creditoService.obterTodosOsCreditosPorNomeDaCategoria(nome)
        );
    }
}
