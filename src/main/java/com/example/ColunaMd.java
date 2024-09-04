package com.example;

import java.util.function.Function;

public class ColunaMd<T> extends AbstractColuna<T> {


    public ColunaMd(Function<T, String> funcaoValorColuna, String titulo) {
        super(funcaoValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "|";
    }

    @Override
    public String fechar() {
        return "";
    }
}
