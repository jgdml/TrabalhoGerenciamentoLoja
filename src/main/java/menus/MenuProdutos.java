package menus;

import sistema.Constantes;
import sistema.Input;

public class MenuProdutos {

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

        if(op.equals("0")){
            return;
        }

        switch (op){

            case "1":
                cadastrarProduto();

            case "2":
                listarProdutos();

            case "3":
                alterarProduto();

            case "4":
                deletarProduto();

            default:
                System.out.println("Opção inválida!");
                break;

        }

    }

    private void cadastrarProduto(){

    }

}
