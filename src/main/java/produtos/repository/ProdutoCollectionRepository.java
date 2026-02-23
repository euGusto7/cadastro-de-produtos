package produtos.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import produtos.model.Categoria;
import produtos.model.Produto;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();

        Produto notebook = new Produto();
        notebook.setNome("Notebook")
                .setDescricao("Notebook Dell Inspiron 15")
                .setPreco(new BigDecimal("3500.0"))
                .setCategoria(CategoriaCollectionRepository.findById(2L))
                .setDataCadastro(LocalDateTime.now());

        save(notebook);
    }

    public static Produto save(Produto produto) {
        if (!produtos.contains(produto)) {
            produto.setId((long) (produtos.size() + 1));
            produtos.add(produto);
            return produto;
        } else {
            JOptionPane.showMessageDialog(null, "Produto já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static List<Produto> findAll() {
        return produtos;
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return produtos.stream()
                .filter(produto -> produto.getCategoria().equals(categoria))
                .toList();
    }
}
