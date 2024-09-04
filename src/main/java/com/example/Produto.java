package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private String id;
    private String nome;
    private String marca;

    public Produto(String id, String nome, String marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }
}
