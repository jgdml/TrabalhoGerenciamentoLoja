package menus;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Usuario;
import org.hibernate.query.criteria.internal.expression.function.UpperFunction;
import sistema.DaoGenerico;
import sistema.Input;
import sistema.PreencherFk;

public class MenuAdmin {

    private final DaoGenerico<Funcionario> daoFuncionario = new DaoGenerico<>(Funcionario.class);

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
        Funcionario f = new Funcionario();

        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                f.preencher();
                PreencherFk.fkFuncionario(f);
                daoFuncionario.salvarOuAtualizar(f);

                break;

            case "2":
                daoFuncionario.printRegistros();

                break;

            case "3":
                f = daoFuncionario.escolher();
                f.preencher();
                daoFuncionario.salvarOuAtualizar(f);

                break;

            case "4":
                daoFuncionario.deletar(daoFuncionario.escolher());

                break;

            case "5":

                f = daoFuncionario.escolher();
                f.getUsuario().setIsAdm(true);

                break;

            case "6":

                f = daoFuncionario.escolher();
                f.getUsuario().setIsAdm(false);

                break;

            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");

    }

}
