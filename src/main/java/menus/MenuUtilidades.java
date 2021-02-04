package menus;

import modelo.CompraProduto;
import modelo.VendaProduto;
import sistema.DaoGenericoAssociativo;
import sistema.Input;

public class MenuUtilidades {

    private final MenuFornecedor menuFornecedor = new MenuFornecedor();
    private final MenuCidadeEstado menuCidadeEstado = new MenuCidadeEstado();
    private final DaoGenericoAssociativo<CompraProduto> daoCompraProduto = new DaoGenericoAssociativo<>(CompraProduto.class);
    private final DaoGenericoAssociativo<VendaProduto> daoVendaProduto = new DaoGenericoAssociativo<>(VendaProduto.class);



    public void executar(){
        String opcao = "";
        do{
            opcao = menuUtilidades();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }

    private String menuUtilidades(){
        System.out.println("┃☰☰\uD835\uDC7C\uD835\uDC95\uD835\uDC8A\uD835\uDC8D\uD835\uDC8A\uD835\uDC85\uD835\uDC82\uD835\uDC85\uD835\uDC86\uD835\uDC94☰☰\n" +
                "┃\n" +
                "┃1. Ver vendas\n" +
                "┃2. Ver compras\n" +
                "┃3. Fornecedor\n" +
                "┃4. Cidade e Estado\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");
    }


    private void executarMenu(final String op) {
        if (op.equals("0")) {
            return;
        }

        switch (op) {

            case "1":
                daoVendaProduto.printRegistros();
                break;

            case "2":
                daoCompraProduto.printRegistros();
                break;

            case "3":
                menuFornecedor.executar();
                break;

            case "4":
                menuCidadeEstado.executar();
                break;

            default:
                System.out.println("Opção inválida!");
                break;

        }

        Input.get("\nPressione enter para continuar...");

    }

}
