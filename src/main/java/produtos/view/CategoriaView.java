package produtos.view;

import javax.swing.JOptionPane;

import produtos.model.Categoria;
import produtos.repository.CategoriaCollectionRepository;

public class CategoriaView {
    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(null, "Selecione uma categoria:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, CategoriaCollectionRepository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;
    }

    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome() + " cadastrada com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public Categoria form(Categoria categoria) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome da categoria:",
                categoria == null ? "" : categoria.getNome());
        return new Categoria(nome);
    }
}
