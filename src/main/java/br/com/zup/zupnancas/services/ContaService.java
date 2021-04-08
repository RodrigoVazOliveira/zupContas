package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta gravarNovaConta(Conta conta) {
        verificarStatus(conta.getStatus());
        return contaRepository.save(conta);
    }

    public void verificarStatus(Status status) {
        if (status.equals(Status.PAGO)) {
            throw new RuntimeException("O status deve ser apenas ARGUARDANDO OU ATRASADO!");
        }
    }
}
