package br.facens.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.facens.projeto01.model.Fornecedor;

public interface FornecedorRepo extends CrudRepository<Fornecedor, Integer> {

}
