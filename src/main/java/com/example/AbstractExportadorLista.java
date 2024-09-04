package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    private List<T> lista;
    private List<Coluna<T>> colunas;

    public AbstractExportadorLista(List<T> lista) {
        this.lista = lista;
        this.colunas = new ArrayList<>();
    }

    final public String exportar() {
        StringBuilder builder = new StringBuilder();

        builder.append(abrirTabela())
                .append(abrirLinhaTitulos())
                .append(gerarColunasTitulos())
                .append(fecharLinhaTitulos())
                .append(gerarLinhas(lista))
                .append(fecharTabela());

        return builder.toString();
    }

    private String gerarLinhas(List<T> lista) {
        return lista
                .stream()
                .map(produto -> abrirLinha() + gerarColunasCorpo(produto) + fecharLinha())
                .collect(Collectors.joining());
    }

    private String gerarColunasCorpo(T item) {
        var builder = new StringBuilder();
        colunas.forEach(coluna -> builder.append(coluna.exportarDado(item)));
        return builder.toString();
    };

    private String gerarColunasTitulos() {
        var builder = new StringBuilder();
        colunas.forEach(coluna -> builder.append(coluna.exportarCabecalho()));
        return builder.toString();
    }

    @Override
    public void addNewColuna(Function<T, String> funcaoValorCol, String titulo) {
        colunas.add(newColuna(funcaoValorCol, titulo));
    }

    protected abstract Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo);
}
