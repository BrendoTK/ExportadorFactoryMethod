package com.example;

import java.util.List;
import java.util.function.Function;

public interface ExportadorLista<T> {

    String abrirTabela();

    String fecharTabela();

    String abrirLinha();

    String fecharLinha();

    String abrirLinhaTitulos();

    String fecharLinhaTitulos();

    String exportar();

    static <T> ExportadorLista<T> newInstance(List<T> lista, String extensao) {
        return switch (extensao.toLowerCase()) {
            case "html" -> new ExportadorListaHtml(lista);
            case "md" -> new ExportadorListaMd(lista);
            default -> throw new IllegalArgumentException("Formato não suportado: " + extensao);
        };
    }
    static <T> ExportadorLista newInstance(List<T> lista) {
        return newInstance(lista, "html");
    }

    void addNewColuna(Function<T, String> funcaoValorCol, String titulo);
}

