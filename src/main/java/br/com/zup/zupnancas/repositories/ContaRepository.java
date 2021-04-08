package br.com.zup.zupnancas.repositories;

import br.com.zup.zupnancas.enumerates.Status;
import br.com.zup.zupnancas.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
    Iterable<Conta> findByStatus(Status status);
}