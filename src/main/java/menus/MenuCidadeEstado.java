package menus;

import modelo.Cidade;
import modelo.Estado;
import sistema.DaoGenerico;
import sistema.Input;


public class MenuCidadeEstado {

    private DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private DaoGenerico<Estado> daoEstado = new DaoGenerico<>(Estado.class);


    public void executar() {
        String opcao = "";
        do {
            opcao = menuCidadeEstado();
            executarMenu(opcao);
        } while (!opcao.equals("0"));

    }

    private String menuCidadeEstado() {
        System.out.println("┃☰☰\uD835\uDC6A\uD835\uDC8A\uD835\uDC85\uD835\uDC82\uD835\uDC85\uD835\uDC86 \uD835\uDC86 \uD835\uDC6C\uD835\uDC94\uD835\uDC95\uD835\uDC82\uD835\uDC85\uD835\uDC90☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar cidade\n" +
                "┃2. Cadastrar estado\n" +
                "┃3. Ver Cidades\n" +
                "┃4. Ver Estados\n" +
                "┃5. Alterar Cidade\n" +
                "┃6. Alterar Estado\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");
    }

    private void executarMenu(final String op) {

        if(op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":

                break;

            case "2":

                break;

            case "3":
                this.daoCidade.printRegistros();
                break;

            case "4":
                this.daoEstado.printRegistros();
                break;

            case "5":

                break;

            case "6":

                break;


            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("Pressione enter para continuar");
    }

}
