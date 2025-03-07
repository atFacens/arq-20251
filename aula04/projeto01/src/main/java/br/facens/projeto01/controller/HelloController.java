package br.facens.projeto01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bean
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{nome}")
    public String getHello(@PathVariable String nome) {
        return "Boa noite " + nome;
    }

    @GetMapping
    public String getHello() {
        return "Boa noite! ";
    }

    @PostMapping
    public String otherHello() {
        return "Outro hello acionado!";
    }
}
