package br.edu.utfpr.crudvaadin.data.service;

import br.edu.utfpr.crudvaadin.data.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Override
    List<Cliente> findAll();

    Cliente findById(long id);

    @Query(value = "from Cliente c where lower(c.primeiroNome) like '%'||lower(?1)||'%' or lower(sobrenome) like '%'||lower(?1)||'%'")
    List<Cliente> findByNome(String nome);
}
