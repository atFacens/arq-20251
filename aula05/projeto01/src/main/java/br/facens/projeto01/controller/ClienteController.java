package br.facens.projeto01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.projeto01.model.Client;
import br.facens.projeto01.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id) {

        Optional<Client> optional = service.getCliente(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
