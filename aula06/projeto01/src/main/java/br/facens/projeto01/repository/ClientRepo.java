package br.facens.projeto01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.facens.projeto01.model.Client;

@Repository
public class ClientRepo {
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
