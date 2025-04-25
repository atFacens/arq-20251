package br.facens.projeto01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.projeto01.model.Fornecedor;
import br.facens.projeto01.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor>  getById(@PathVariable int id) {
        Optional<Fornecedor> optinal = service.getById(id);
        return ResponseEntity.ok(optinal.get());
    }
}
