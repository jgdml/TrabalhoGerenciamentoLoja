import menus.*;
import modelo.Categoria;
import modelo.Produto;
import sistema.Constantes;
import sistema.DaoGenerico;

import sistema.Menus;
import testes.Inserts;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Inserts.init();

        MenuAdmin menuAdmin = new MenuAdmin();

        menuAdmin.executar();


    }
}
