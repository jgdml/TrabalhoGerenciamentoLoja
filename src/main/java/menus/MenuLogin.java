package menus;

import infra.EMFProducer;
import modelo.Usuario;
import sistema.Constantes;
import sistema.Input;
import sistema.Login;

import javax.persistence.EntityManager;
import java.util.List;

public class MenuLogin {



    public String executar() {
        Login funcoesLogin = new Login();

        System.out.print("┃☰☰\uD835\uDE47\uD835\uDE64\uD835\uDE5C\uD835\uDE5E\uD835\uDE63☰☰\n" +
                "┃\n" +
                "┃Login:");

        String login = Input.get("");

        System.out.print("┃\n" +
                "┃\n" +
                "┃Senha:");

        String senha = Input.get("");
        System.out.println("┃\n" +
                "┃☰☰☰☰☰☰☰");

        String validarLogin = funcoesLogin.buscarLogin(login, senha);

        return validarLogin;
    }

}
