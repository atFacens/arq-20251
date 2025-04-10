package br.facens.projeto01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.projeto01.model.Client;
import br.facens.projeto01.model.dto.ClientDTO;
import br.facens.projeto01.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable long id) {

        Optional<ClientDTO> optional = service.getClient(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = service.getAll();

        if (clients.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> createCliente(@RequestBody ClientDTO clientDTO) {
        Client newClient = service.createClient(clientDTO);

        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        boolean deleted = service.deleteById(id);

        if(deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Client> replaceClient(@RequestBody Client client) {
        Client clientUpdated = service.replaceClient(client);

        if(clientUpdated != null) {
            return ResponseEntity.ok(clientUpdated);
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        Client clientUpdated = service.updateClient(client);

        if(clientUpdated != null) {
            return ResponseEntity.ok(clientUpdated);
        }
        return ResponseEntity.badRequest().build();
    }

}
