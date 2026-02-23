package produtos.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import produtos.model.Categoria;
import produtos.model.Produto;
import produtos.repository.ProdutoCollectionRepository;

public class ProdutoView {
    public static Produto form(Produto produto) {
        Categoria categoria = null;

        do {
            categoria = CategoriaView.select(produto.getCategoria());
        } while (categoria == null);

        String nome = "";

        do {
            nome = JOptionPane.showInputDialog(null, "Digite o nome do produto:", produto.getNome());
        } while (nome.equals(""));

        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do produto:", produto.getDescricao());

        double preco = 0;

        do {
            try {
                String precoStr = JOptionPane.showInputDialog(null, "Digite o preço do produto:", produto.getPreco());
                preco = Double.parseDouble(precoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número válido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (preco <= 0);

        Produto ret = produto;

        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataCadastro(LocalDateTime.now())
                .setPreco(new BigDecimal(preco));

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() + " cadastrado com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static Produto select(Produto produto) {
        Produto ret = (Produto) JOptionPane.showInputDialog(null, "Selecione um produto:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, ProdutoCollectionRepository.findAll().toArray(),
                produto == null ? 1 : produto);
        return ret;
    }

    public static void update(Produto produto) {
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto: " + produto.getNome() + "\nDescrição: " + produto.getDescricao()
                + "\nPreço: R$ " + produto.getPreco(), "Detalhes do Produto", JOptionPane.INFORMATION_MESSAGE);
    }
}
