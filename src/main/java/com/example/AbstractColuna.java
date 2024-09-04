package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

@Getter
@Setter
public abstract class AbstractColuna<T> implements Coluna<T> {
    private String titulo;
    private Function<T, String> funcaoValorColuna;

    public AbstractColuna(Function<T, String> funcaoValorColuna, String titulo) {
        this.titulo = titulo;
        this.funcaoValorColuna = funcaoValorColuna;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(T objeto) {
        return abrir() + funcaoValorColuna.apply(objeto) + fechar();
    }
}
