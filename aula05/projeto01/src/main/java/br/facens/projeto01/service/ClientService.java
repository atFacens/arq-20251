package br.facens.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.facens.projeto01.model.Client;

@Service
public class ClientService {
    // simulando dados de Clientes
    private List<Client> clientes = List.of(
            new Client(1, "Emerson", "emerson@paduan.dev.br"),
            new Client(2, "Paduan", "paduan@paduan.dev.br"),
            new Client(3, "Outro", "outro@paduan.dev.br")

    );

    public Optional<Client> getCliente(long id) {
        for (Client client : clientes) {
            if (client.getId() == id) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }
}
