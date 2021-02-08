package menus;

import cadastro.PreencherCompra;
import cadastro.PreencherVenda;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import modelo.CompraProduto;
import modelo.VendaProduto;
import sistema.*;


public class MenuPrincipal {

    private final String isAdm;
    private final MenuClientes menuClientes = new MenuClientes();
    private final MenuUtilidades menuUtilidades = new MenuUtilidades();
    private final MenuAdmin menuAdmin = new MenuAdmin();
    private final MenuProdutos menuProdutos = new MenuProdutos();

    private final PreencherVenda preencherVenda = new PreencherVenda();
    private final PreencherCompra preencherCompra = new PreencherCompra();
    private final DaoGenericoAssociativo<VendaProduto> daoVendaProduto = new DaoGenericoAssociativo<>(VendaProduto.class);
    private final DaoGenericoAssociativo<CompraProduto> daoCompraProduto = new DaoGenericoAssociativo<>(CompraProduto.class);


    public MenuPrincipal(String isAdm) {
        this.isAdm = isAdm;
    }


    public void executarPrincipal(){
        String opcao = "";
        do{
            opcao = menuPrincipal();
            executarMenu(opcao);
        } while (!opcao.equals("0"));
    }


    private String menuPrincipal() {

        System.out.println("┃☰☰\uD835\uDC6E\uD835\uDC86\uD835\uDC93\uD835\uDC86\uD835\uDC8F\uD835\uDC84\uD835\uDC8A\uD835\uDC82\uD835\uDC8E\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC90 \uD835\uDC73\uD835\uDC90\uD835\uDC8B\uD835\uDC82☰☰\n" +
                "┃\n" +
                "┃1. Realizar Venda\n" +
                "┃2. Realizar Compra\n" +
                "┃3. Produtos\n" +
                "┃4. Clientes\n" +
                "┃5. Utilidades");

        //Se o cara for adm aparece um menu a mais
        if(this.isAdm.equals(Constantes.LOGIN_ISADM)){
            System.out.print("┃6. Admin\n");
        }
        System.out.println("┃0. Sair\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");

    }

    private void executarMenu(final String op){

        try {
            if (op.equals("0")) {
                System.out.println("\nDeslogando");
                for (int i = 0; i < Constantes.BRUNO_HENRIQUE.length; i++) {
                Thread.currentThread().sleep(1000);
                    System.out.print(Constantes.BRUNO_HENRIQUE[i]);
                }
                Thread.currentThread().sleep(1000);
                System.out.println("Deslogado com Sucesso!");
                return;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (op){
            case "1":
                VendaProduto vendaProduto = preencherVenda.preencherTudo();
                daoVendaProduto.salvarOuAtualizar(vendaProduto);
                break;

            case "2":
                CompraProduto compraProduto = preencherCompra.preencherTudo();
                daoCompraProduto.salvarOuAtualizar(compraProduto);
                break;

            case "3":
                menuProdutos.executar();
                break;

            case  "4":
                menuClientes.executar();
                break;

            case "5":
                menuUtilidades.executar();
                break;

            case "6":
                if(this.isAdm.equals(Constantes.LOGIN_ISADM)){
                    menuAdmin.executar();
                    break;
                }
                else{
                    System.out.println(Constantes.USUARIO_NAO_ADEMENE);
                    break;
                }

            default:
                System.out.println("Opção inválida!");
                Input.get("\nPressione enter para continuar...");
                break;
        }
    }
}
