package produtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// import produtos.model.Categoria;
import produtos.model.Produto;
import produtos.repository.CategoriaCollectionRepository;
import produtos.repository.ProdutoCollectionRepository;

public class Main {
    public static void main(String[] args) {
        // Categoria categoria = new Categoria();
        // categoria.setNome("Informática");
        // Categoria categoriaSalva = CategoriaCollectionRepository.save(categoria);
        // System.out.println("Categoria salva: " + categoriaSalva);

        Produto produto = new Produto();
        produto.setNome("Kindle")
                .setDescricao("E-book reader da Amazon")
                .setPreco(BigDecimal.valueOf(800))
                .setCategoria(CategoriaCollectionRepository.findByNome("eletrônicos").get(0))
                .setDataCadastro(LocalDateTime.now());
        Produto produto1 = ProdutoCollectionRepository.save(produto);
        System.out.println("ID: " + produto1.getId() + " - Nome: " + produto1.getNome() + " - Categoria: "
                + produto1.getCategoria());
    }
}
