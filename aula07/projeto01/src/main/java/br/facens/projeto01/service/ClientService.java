package br.facens.projeto01.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.facens.projeto01.model.Client;
import br.facens.projeto01.model.dto.ClientDTO;
import br.facens.projeto01.repository.ClientRepo;

@Service
public class ClientService {

    private ClientRepo repo;

    public ClientService(ClientRepo repo) {
        this.repo = repo;
    }

    public Optional<ClientDTO> getCliente(long id) {
        if (id <= 0) {
            return Optional.empty();
        }

        Optional<Client> clientOptional = repo.findById(id);
        if (clientOptional.isEmpty()) {
            return Optional.empty();
        }

        Client client = clientOptional.get();
        return Optional.of(new ClientDTO(client));
    }
}
