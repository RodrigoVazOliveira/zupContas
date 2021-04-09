package br.com.zup.zupnancas.exceptions;

import br.com.zup.zupnancas.exceptions.categoria.CategoriaVaziaException;
import br.com.zup.zupnancas.exceptions.categoria.PesquisarCategoriaPorIdException;
import br.com.zup.zupnancas.exceptions.conta.CadastroDeContaException;
import br.com.zup.zupnancas.exceptions.conta.PesquisarContaPorIdException;
import br.com.zup.zupnancas.exceptions.conta.PesquisarContaPorStatusException;
import br.com.zup.zupnancas.exceptions.credito.CreditoSemCadastroException;
import br.com.zup.zupnancas.exceptions.credito.PesquisarCreditoPorNomeDeCategoriaException;
import br.com.zup.zupnancas.exceptions.saldo.PesquisarSaldoPorCpfException;
import br.com.zup.zupnancas.exceptions.saldo.SemRegistroSaldoException;
import br.com.zup.zupnancas.exceptions.validacao.CampoErro;
import br.com.zup.zupnancas.exceptions.validacao.ValidacaoDeArgumentoException;
import br.com.zup.zupnancas.exceptions.validacao.ValidacaoDeSemArgsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerAdviceException  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidacaoDeArgumentoException validacaoDeArgumentoException = new ValidacaoDeArgumentoException(
                "Validação de campo",
                status.value(),
                status.getReasonPhrase(),
                obterErrosDeValidacaoDeCampos(ex)
        );
        return ResponseEntity.status(status).body(validacaoDeArgumentoException);
    }

    private List<CampoErro> obterErrosDeValidacaoDeCampos(MethodArgumentNotValidException exception) {
        List<CampoErro> campoErros = new ArrayList<>();
        for (FieldError fieldError : exception.getFieldErrors()) {
            campoErros.add(new CampoErro(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return campoErros;
    }

    @ExceptionHandler({PesquisarCategoriaPorIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarCategoriaPorIdException(PesquisarCategoriaPorIdException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
            ex.getTipoDeErro(),
            ex.getStatus(),
            ex.getDescricaoStatus(),
            ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({CategoriaVaziaException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException categoriaVaziaException(CategoriaVaziaException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({CadastroDeContaException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException cadastroDeContaException(CadastroDeContaException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarContaPorIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarContaPorIdException(PesquisarContaPorIdException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarContaPorStatusException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarContaPorStatusException(PesquisarContaPorStatusException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarSaldoPorCpfException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidacaoDeSemArgsException pesquisarSaldoPorCpfException(PesquisarSaldoPorCpfException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({CreditoSemCadastroException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException creditoSemCadastroException(CreditoSemCadastroException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({PesquisarCreditoPorNomeDeCategoriaException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException pesquisarCreditoPorNomeDeCategoriaException(
            PesquisarCreditoPorNomeDeCategoriaException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }

    @ExceptionHandler({SemRegistroSaldoException.class})
    @ResponseStatus(HttpStatus.OK)
    public ValidacaoDeSemArgsException semRegistroSaldoException(
            SemRegistroSaldoException ex) {
        ValidacaoDeSemArgsException modeloEx = new ValidacaoDeSemArgsException(
                ex.getTipoDeErro(),
                ex.getStatus(),
                ex.getDescricaoStatus(),
                ex.getMessage()
        );
        return modeloEx;
    }
}
