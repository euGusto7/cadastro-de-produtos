package produtos;

import java.util.List;
import produtos.model.Categoria;
import produtos.model.Produto;
import produtos.repository.CategoriaCollectionRepository;
import produtos.repository.ProdutoCollectionRepository;
import produtos.view.CategoriaView;
import produtos.view.Opcao;
import produtos.view.ProdutoView;

public class Main {
    public static void main(String[] args) {
        Opcao opcao = null;
        do {
            switch (opcao = produtos.view.OpcaoView.select()) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarSistema();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void alterarProduto() {
        System.out.println("Alterar Produto");
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void consultarProdutoPorId() {
        System.out.println("Consultar Produto por ID");
    }

    private static void consultarProdutoPorCategoria() {
        System.out.println("Consultar Produto por Categoria");
        Categoria categoria = CategoriaView.select(null);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado para a categoria: " + categoria.getNome());
        } else {
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }
    }

    private static void encerrarSistema() {
        System.exit(0);
    }
}
