package br.facens.projeto01.model.dto;

import br.facens.projeto01.model.Client;

public class ClientDTO {
    private String name;
    private String email;

    public ClientDTO(Client client) {
        name = client.getName();
        email = client.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
