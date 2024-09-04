package com.example;

import java.util.function.Function;

public class ColunaHtml<T> extends AbstractColuna<T> {


    public ColunaHtml(Function<T, String> funcaoValorColuna, String titulo) {
        super(funcaoValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return "</td>";
    }
}
