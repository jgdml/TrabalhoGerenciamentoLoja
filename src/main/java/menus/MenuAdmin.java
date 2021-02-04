package menus;

import modelo.Cliente;
import modelo.Usuario;
import sistema.DaoGenerico;
import sistema.Input;
import sistema.PreencherFk;

public class MenuAdmin {

    private final DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>(Usuario.class);

    public void executar(){
        String opcao = "";
        do{
            opcao = menuAdmin();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }

    private String menuAdmin() {
        System.out.println("┃☰☰\uD835\uDC68\uD835\uDC85\uD835\uDC8E\uD835\uDC8A\uD835\uDC8F☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar usuário\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar usuário\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");
    }

    private void executarMenu(final String op) {
        Usuario u = new Usuario();

        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                u.preencher();
                daoUsuario.salvarOuAtualizar(u);

                break;

            case "2":
                daoUsuario.printRegistros();

                break;

            case "3":
                u = daoUsuario.escolher();
                u.preencher();
                daoUsuario.salvarOuAtualizar(u);

                break;

            case "4":
                daoUsuario.deletar(daoUsuario.escolher());

                break;

            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");

    }

}
