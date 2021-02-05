package menus;

import cadastro.PreencherCidade;
import modelo.Cidade;
import modelo.Estado;
import sistema.DaoGenerico;
import sistema.Input;


public class MenuCidadeEstado {

    private final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private final DaoGenerico<Estado> daoEstado = new DaoGenerico<>(Estado.class);

    private final PreencherCidade preencherCidade = new PreencherCidade();


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
        Cidade cidade;
        Estado estado = new Estado();

        if(op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                cidade = preencherCidade.preencherTudo();
                daoCidade.salvarOuAtualizar(cidade);
                break;

            case "2":
                estado.preencher();
                daoEstado.salvarOuAtualizar(estado);
                break;

            case "3":
                daoCidade.printRegistros();
                break;

            case "4":
                daoEstado.printRegistros();
                break;

            case "5":
                cidade = daoCidade.escolher();
                cidade.preencher();
                daoCidade.salvarOuAtualizar(cidade);
                break;

            case "6":
                estado = daoEstado.escolher();
                estado.preencher();
                daoEstado.salvarOuAtualizar(estado);
                break;


            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");
    }

}
