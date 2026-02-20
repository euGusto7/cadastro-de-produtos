package produtos;

import produtos.model.Categoria;
import produtos.repository.CategoriaCollectionRepository;
import produtos.view.CategoriaView;
import produtos.view.Opcao;

public class Main {
    public static void main(String[] args) {
        Opcao opcao = null;
        do {
            // opcao = OpcaoView.select();
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
        Categoria categoria = view.form();
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }

    private static void cadastrarProduto() {
        System.out.println("Cadastrar Produto");
    }

    private static void alterarProduto() {
        System.out.println("Alterar Produto");
    }

    private static void consultarProdutoPorId() {
        System.out.println("Consultar Produto por ID");
    }

    private static void consultarProdutoPorCategoria() {
        System.out.println("Consultar Produto por Categoria");
    }

    private static void encerrarSistema() {
        System.exit(0);
    }
}
