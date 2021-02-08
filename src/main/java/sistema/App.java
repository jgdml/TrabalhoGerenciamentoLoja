package sistema;

import menus.MenuLogin;
import menus.MenuPrincipal;

import java.awt.*;

public class App {

    MenuLogin menuLogin = new MenuLogin();
    MenuPrincipal menuPrincipal;

    public void init() {
        while (true) {
            bemVindo();
            String login = menuLogin.executar();
            if (!(login.equals(Constantes.LOGIN_FALSE))) {
                menuPrincipal = new MenuPrincipal(login);
                menuPrincipal.executarPrincipal();
            } else {
                System.out.println(Constantes.LOGIN_NAO_ENCONTRADO);
            }

        }

    }

    private void bemVindo() {

        System.out.println("\n【Este é o \uD835\uDC6E\uD835\uDC86\uD835\uDC93\uD835\uDC86\uD835\uDC8F\uD835\uDC84\uD835\uDC8A\uD835\uDC82\uD835\uDC8E\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC90 \uD835\uDC73\uD835\uDC90\uD835\uDC8B\uD835\uDC82】");
        System.out.println("【Seja Bem Vindo!】");

    }
}
