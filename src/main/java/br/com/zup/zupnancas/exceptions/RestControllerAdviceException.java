package br.com.zup.zupnancas.exceptions;

import br.com.zup.zupnancas.exceptions.categoria.PesquisarCategoriaPorIdException;
import br.com.zup.zupnancas.exceptions.conta.CadastroDeContaException;
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
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
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
}
