import menus.*;
import modelo.Categoria;
import modelo.Produto;
import sistema.App;
import sistema.Constantes;
import sistema.DaoGenerico;

import testes.Inserts;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Inserts.init();

        App app = new App();

        app.init();

    }
}
