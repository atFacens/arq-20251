package br.facens.projeto01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.facens.projeto01.model.Client;

// CRUD = Create, Read, Update, Delete
public interface ClientRepo extends CrudRepository<Client, Long>{

    Optional<Client> findByEmail(String email);

    List<Client> findByNameContainingOrderByNameDesc(String name);

}
