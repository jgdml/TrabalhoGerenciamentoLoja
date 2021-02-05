package menus;

import cadastro.PreencherProduto;
import modelo.Produto;
import sistema.DaoGenerico;
import sistema.Input;


public class MenuProdutos {

    private DaoGenerico<Produto> daoProduto = new DaoGenerico<>(Produto.class);
    private final PreencherProduto preencherProduto = new PreencherProduto();


    public void executar(){
        String opcao = "";
        do{
            opcao = menuProdutos();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }


    private String menuProdutos() {

        System.out.println("┃☰☰\uD835\uDC77\uD835\uDC93\uD835\uDC90\uD835\uDC85\uD835\uDC96\uD835\uDC95\uD835\uDC90\uD835\uDC94☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar novo\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");

    }

    private void executarMenu(final String op) {

        Produto produto = new Produto();

        if(op.equals("0")){
            return;
        }

        switch (op){

            case "1":
                produto = preencherProduto.preencherTudo();
                daoProduto.salvarOuAtualizar(produto);
                break;
            case "2":
                this.daoProduto.printRegistros();
                break;
            case "3":
                //Função de ALterar cadastro
                produto = daoProduto.escolher();
                produto.preencher();
                daoProduto.salvarOuAtualizar(produto);
                break;
            case "4":

                this.daoProduto.deletar(this.daoProduto.escolher());
                break;
            default:
                System.out.println("Opção inválida!");
                break;

        }
        Input.get("\nPressione enter para continuar...");
    }
}
