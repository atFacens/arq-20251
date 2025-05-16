package br.facens.projeto01.model.dto;

import br.facens.projeto01.model.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientDTO {
    private String name;

    @NotNull(message = "O email é obrigatório")
    @NotBlank(message = "O email não pode ser deixado em branco")
    @Email(message = "O email é inválido")
    private String email;

    public ClientDTO(){}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
