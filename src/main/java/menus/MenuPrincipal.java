package menus;

import sistema.Constantes;
import sistema.Input;

public class MenuPrincipal {

    private String isAdm;
    private final MenuClientes menuClientes = new MenuClientes();
    private final MenuUtilidades menuUtilidades = new MenuUtilidades();


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
                "┃5. Utilidades\n");

        //Se o cara for adm aparece um menu a mais
        if(this.isAdm.equals(Constantes.LOGIN_ISADM)){
            System.out.println("┃6. Admin\n");
        }
        System.out.println("┃0. Sair\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");

        return Input.get("Opção: ");

    }

    private void executarMenu(final String op){

        if(op.equals("0")){
            return;
        }
        switch (op){
            case "1":
                System.out.println("Menu faltando");

            case "2":
                System.out.println("Menu faltando");

            case "3":
//                MenuProdutos.executar();

            case  "4":
                menuClientes.executar();

            case "5":
                menuUtilidades.executar();

            case "6":
                if(this.isAdm.equals(Constantes.LOGIN_ISADM)){
//                    MenuAdm.executar();
                }else{
                    break;
                }
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }
}
