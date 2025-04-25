package br.facens.projeto01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.projeto01.model.Produto;
import br.facens.projeto01.repository.ProdutoRepo;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepo repo;

    public Optional<Produto> getById(int id) {
        return repo.findById(id);
    }
}
