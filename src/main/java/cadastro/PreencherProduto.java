package cadastro;

import modelo.Categoria;
import modelo.Produto;
import sistema.DaoGenerico;

public class PreencherProduto extends PreencherBase {

    // Instanciar o Dao da FK de Produto, neste caso, o daoCategoria
    private final DaoGenerico<Categoria> daoCategoria = new DaoGenerico<>(Categoria.class);


    public Produto preencherTudo(){
        // Instancia um produto novo porque o usuário selecionou para criar um novo produto
        Produto produto = new Produto();
        // Prencher o produto criada
        produto.preencher();

        // Fazer o input para saber se o usuário quer criar uma Categoria(FK) ou selecionar um que ja existe
        String tipo = askTipo("Categoria");

        // Instanciar a FK
        Categoria categoria = new Categoria();


        // Caso o usuário quiser cadastrar uma nova Categoria(FK)
        if (tipo.equals("1")){
            // Preencher a categoria criado
            categoria.preencher();

            // Salvar a nova Categoria no banco
            daoCategoria.salvarOuAtualizar(categoria);
        }
        else{
            // Caso o usuário quiser escolher uma Categoria(FK) existente
            categoria = daoCategoria.escolher();
        }

        // Settar que a Produto criada pertence a Categoria(FK) criada
        produto.setCategoria(categoria);

        // Retornar a produto para salvar ela com o daoCategoria no Menu
        return produto;
    }

}
