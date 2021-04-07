package br.com.zup.zupconta.repositories;

import br.com.zup.zupconta.models.Saldo;
import org.springframework.data.repository.CrudRepository;

public interface SaldoRepository extends CrudRepository<Saldo, String> {
}
