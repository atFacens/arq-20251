package br.facens.projeto01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.projeto01.model.Fornecedor;
import br.facens.projeto01.repository.FornecedorRepo;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepo repo;

    public Optional<Fornecedor> getById(int id) {
        return repo.findById(id);
    }

}
