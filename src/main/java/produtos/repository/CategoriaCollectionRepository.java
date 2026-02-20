package produtos.repository;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import produtos.model.Categoria;

public class CategoriaCollectionRepository {
    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();

        Categoria eletronicos = new Categoria(1L, "Eletrônicos");
        Categoria celulares = new Categoria(2L, "Celulares");
        Categoria livros = new Categoria(3L, "Livros");

        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);
    }

    public List<Categoria> findAll() {
        return categorias;
    }

    public static Categoria findById(Long id) {
        return categorias
                .stream()
                .filter(categoria -> categoria.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Categoria> findByNome(String nome) {
        return categorias
                .stream()
                .filter(categoria -> categoria.getNome().equalsIgnoreCase(nome))
                .toList();
    }

    public static Categoria save(Categoria categoria) {
        if (!categorias.contains(categoria)) {
            categoria.setId((long) (categorias.size() + 1));
            categorias.add(categoria);
            return categoria;
        } else {
            JOptionPane.showMessageDialog(null, "Categoria já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
