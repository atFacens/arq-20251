package br.facens.projeto01.service;

import java.util.List;
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

    public Optional<ClientDTO> getClient(long id) {
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

    public Client createClient(ClientDTO clientDTO) {
        Client clientToInsert = new Client(0, clientDTO.getName(), clientDTO.getEmail());
        return repo.save(clientToInsert);
    }

    public List<Client> getAll() {
        return (List<Client>) repo.findAll();
    }

    public boolean deleteById(long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Client replaceClient(Client client) {
        if (client.getId() > 0) {
            return repo.save(client);
        }
        return null;
    }

    public Client updateClient(Client client) {
        // *** Para quem viu o final da aula, o problema estava neste if
        if (client.getId() == 0) { 
            return null;
        }

        Optional<Client> optionalClient = repo.findById(client.getId());
        if (optionalClient.isEmpty()) {
            return null;
        }

        Client currentClient = optionalClient.get();
        if (client.getName() != null && !client.getName().isBlank()) {
            currentClient.setName(client.getName());
        }
        if (client.getEmail() != null && !client.getEmail().isBlank()) {
            currentClient.setEmail(client.getEmail());
        }
        return repo.save(currentClient);
    }

    public Optional<Client> getClientByEmail(String email) {
       return repo.findByEmail(email);
    }

    public List<Client> getClientByName(String name) {
       return repo.findByNameContainingOrderByNameDesc(name);
    }
}
