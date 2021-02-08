package menus;

import cadastro.PreencherFuncionario;
import modelo.Funcionario;
import modelo.Usuario;
import sistema.DaoGenerico;
import sistema.Input;


public class MenuAdmin {

    private final DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>(Usuario.class);
    private final DaoGenerico<Funcionario> daoFuncionario = new DaoGenerico<>(Funcionario.class);
    private final PreencherFuncionario preencherFuncionario = new PreencherFuncionario();

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
                "┃1. Cadastrar funcionario\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar funcionario\n" +
                "┃5. Conceder ADM\n" +
                "┃6. Remover ADM\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");
    }

    private void executarMenu(final String op) {
        Funcionario funcionario;
        Usuario usuario;

        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                funcionario = preencherFuncionario.preencherTudo();
                daoFuncionario.salvarOuAtualizar(funcionario);

                break;

            case "2":
                daoFuncionario.printRegistros();

                break;

            case "3":
                funcionario = daoFuncionario.escolher();
                funcionario.preencher();
                daoFuncionario.salvarOuAtualizar(funcionario);

                break;

            case "4":
                daoFuncionario.deletar(daoFuncionario.escolher());

                break;

            case "5":
                funcionario = daoFuncionario.escolher();
                usuario = funcionario.getUsuario();
                usuario.setIsAdm(true);
                daoUsuario.salvarOuAtualizar(usuario);
                break;

            case "6":
                funcionario = daoFuncionario.escolher();
                usuario = funcionario.getUsuario();
                usuario.setIsAdm(false);
                daoUsuario.salvarOuAtualizar(usuario);
                break;

            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");

    }

}
