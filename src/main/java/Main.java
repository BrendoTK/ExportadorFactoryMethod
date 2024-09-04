import com.example.ExportadorLista;
import com.example.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var listProdutos = List.of(
                new Produto("1", "SmartTv", "LG"),
                new Produto("2", "Smartphone", "Samsung"),
                new Produto("3", "Playstation", "Sony")
        );

        var exportadorHtml = ExportadorLista.newInstance(listProdutos, "html");
        exportadorHtml.addNewColuna(Produto::getId, "Identifier");
        exportadorHtml.addNewColuna(Produto::getNome, "Nome");
        exportadorHtml.addNewColuna(Produto::getMarca, "Marca");
        System.out.println(exportadorHtml.exportar());

        System.out.println();
        var exportadorMd = ExportadorLista.newInstance(listProdutos, "md");
        exportadorMd.addNewColuna(Produto::getId, "Identifier");
        exportadorMd.addNewColuna(Produto::getNome, "Nome");
        exportadorMd.addNewColuna(Produto::getMarca, "Marca");
        System.out.println(exportadorMd.exportar());
    }
}
