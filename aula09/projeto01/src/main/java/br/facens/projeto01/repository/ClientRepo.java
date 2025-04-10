package br.facens.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.facens.projeto01.model.Client;

// CRUD = Create, Read, Update, Delete
public interface ClientRepo extends CrudRepository<Client, Long>{

}
