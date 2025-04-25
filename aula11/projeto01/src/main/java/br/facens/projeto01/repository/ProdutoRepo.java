package br.facens.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.facens.projeto01.model.Produto;

public interface ProdutoRepo extends CrudRepository<Produto, Integer> {

}
