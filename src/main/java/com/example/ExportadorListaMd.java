package com.example;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaMd<T> extends AbstractExportadorLista<T> {

    public ExportadorListaMd(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }

    @Override
    public String abrirLinha() {
        return "\n";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    protected Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return new ColunaMd<>(funcaoValorColuna, titulo);
    }
}
