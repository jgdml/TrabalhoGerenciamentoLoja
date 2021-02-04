package menus;

import modelo.Cliente;
import modelo.Fornecedor;
import sistema.Constantes;
import sistema.DaoGenerico;
import sistema.Input;
import sistema.PreencherFk;

public class MenuFornecedor {

    private DaoGenerico<Fornecedor> daoFornecedor = new DaoGenerico<>(Fornecedor.class);

    public void executar(){
        String opcao = "";
        do{
            opcao = menuFornecedor();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }


    private String menuFornecedor() {


        System.out.println("┃☰☰\uD835\uDC6D\uD835\uDC90\uD835\uDC93\uD835\uDC8F\uD835\uDC86\uD835\uDC84\uD835\uDC86\uD835\uDC85\uD835\uDC90\uD835\uDC93☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar novo\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰");


        return Input.get("Opção: ");

    }

    private void executarMenu(final String op) {

        Fornecedor fc = new Fornecedor();

        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                fc.preencher();
                PreencherFk.fkFornecedor(fc);
                daoFornecedor.salvarOuAtualizar(fc);

                break;

            case "2":
                this.daoFornecedor.printRegistros();

                break;

            case "3":
                fc = daoFornecedor.escolher();
                fc.preencher();
                daoFornecedor.salvarOuAtualizar(fc);

                break;

            case "4":
                this.daoFornecedor.deletar(this.daoFornecedor.escolher());
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
        Input.get("\nPressione enter para continuar...");
    }
}
