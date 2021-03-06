package menus;

import cadastro.PreencherCliente;
import modelo.Cliente;
import sistema.DaoGenerico;
import sistema.Input;

public class MenuClientes {

    private final DaoGenerico<Cliente> daoCliente = new DaoGenerico<>(Cliente.class);
    private final PreencherCliente preencherCliente = new PreencherCliente();

    public void executar(){
        String opcao = "";
        do{
            opcao = menuClientes();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }

    private String menuClientes(){
        System.out.println("┃☰☰\uD835\uDC6A\uD835\uDC8D\uD835\uDC8A\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC86\uD835\uDC94☰☰\n" +
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
        Cliente c;

        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                c = preencherCliente.preencherTudo();
                daoCliente.salvarOuAtualizar(c);
                break;

            case "2":
                daoCliente.printRegistros();
                break;

            case "3":
                c = daoCliente.escolher();
                c.preencher();
                daoCliente.salvarOuAtualizar(c);
                break;

            case "4":
                daoCliente.deletar(daoCliente.escolher());
                break;

            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");

    }
}
