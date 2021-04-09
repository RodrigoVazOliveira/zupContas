package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.saldo.PesquisarSaldoPorCpfException;
import br.com.zup.zupnancas.exceptions.saldo.SemRegistroSaldoException;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    private final SaldoRepository saldoRepository;

    @Autowired
    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Saldo gravarNovoSaldo(Saldo saldo) {
        return saldoRepository.save(saldo);
    }

    public Saldo pesquisarSaldoPorCpf(String cpf) {
        Optional<Saldo> optionalSaldo = saldoRepository.findById(cpf);

        if (optionalSaldo.isEmpty()) {
            throw new PesquisarSaldoPorCpfException("Não existe saldo com o CPF " + cpf);
        }

        return optionalSaldo.get();
    }

    /**
     * Método para adicionar o valor do crédito ao saldo
     * busca o saldo que foi passado no crédito
     * após isso é feito a soma do valor e gravado no banco de dados
     * @param credito
     * @exception PesquisarSaldoPorCpfException
     * */
    public void creditarSaldo(Credito credito) {
        Saldo saldo = pesquisarSaldoPorCpf(credito.getSaldo().getCpf());
        Double valorAtualizado = saldo.getValor() + credito.getValor();
        saldo.setValor(valorAtualizado);
        gravarNovoSaldo(saldo);
    }

    /**
     * o método é responsavel por atualizar o saldo
     * caso possua saldo suficiente
     * */
    public Boolean debitarConta(Conta conta) {
        Saldo saldo = pesquisarSaldoPorCpf(conta.getSaldo().getCpf());
        Double limiteDebito = saldo.getLimite() + saldo.getValor();

        if (limiteDebito < conta.getValor()) {
            return false;
        }

        saldo.setValor(saldo.getValor() - conta.getValor());
        gravarNovoSaldo(saldo);

        return true;
    }

    public Iterable<Saldo> obterTodosSaldos() {
        if (saldoRepository.count() == 0) {
            throw new SemRegistroSaldoException("nenhum registro de saldo foi feito!");
        }
        return saldoRepository.findAll();
    }
}
