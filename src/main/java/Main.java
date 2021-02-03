import menus.MenuClientes;
import menus.MenuProdutos;
import modelo.Categoria;
import sistema.DaoGenerico;

import sistema.Menus;
import testes.Inserts;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Inserts.init();
//        Menus.bemVindo();
//        Menus.menuLogin();

//        MenuClientes mc = new MenuClientes();

        MenuProdutos menuProdutos = new MenuProdutos();
        menuProdutos.executar();


    }
}
