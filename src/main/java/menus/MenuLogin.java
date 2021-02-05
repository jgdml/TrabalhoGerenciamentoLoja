package menus;

import infra.EMFProducer;
import modelo.Usuario;
import sistema.Constantes;
import sistema.Input;

import javax.persistence.EntityManager;
import java.util.List;

public class MenuLogin {
    private static final EntityManager em = EMFProducer.getEmf().createEntityManager();


    public String buscarLogin(String login, String senha){

        String jpql = String.format("SELECT x FROM Usuario x WHERE x.status != '%s' AND x.login = '%s' AND x.senha = '%s'", Constantes.STATUS_INATIVO, login, senha);

        List<Usuario> res = em.createQuery(jpql).getResultList();


        try{
            return validaLogin(res.get(0));
        }
        catch(IndexOutOfBoundsException err){
            return validaLogin(new Usuario());
        }

    }

    //Valida se o login do usuario não está null e retorna o status
    // A = isAdm | S = LoginTrue | N = LoginFalse
    private String validaLogin(Usuario usuario){

        if(usuario != null){
            if(usuario.getIsAdm()){
                return Constantes.LOGIN_ISADM;
            }else {
                return Constantes.LOGIN_TRUE;
            }
        } else{
            return Constantes.LOGIN_FALSE;
        }
    }

    public String menuLogin() {
        System.out.println("┃☰☰\uD835\uDE47\uD835\uDE64\uD835\uDE5C\uD835\uDE5E\uD835\uDE63☰☰\n" +
                "┃\n" +
                "┃Login:");

        String login = Input.get("");

        System.out.println("┃\n" +
                "┃\n" +
                "┃Senha:");

        String senha = Input.get("");
        System.out.println("┃\n" +
                "┃☰☰☰☰☰☰☰");

        String validarLogin = buscarLogin(login, senha);

        return validarLogin;
    }

    public void bemVindo() {

        System.out.println("\n【Este é o \uD835\uDC6E\uD835\uDC86\uD835\uDC93\uD835\uDC86\uD835\uDC8F\uD835\uDC84\uD835\uDC8A\uD835\uDC82\uD835\uDC8E\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC90 \uD835\uDC73\uD835\uDC90\uD835\uDC8B\uD835\uDC82】");
        System.out.println("【Seja Bem Vindo!】");

    }

    public void init() {
        while (true) {
            bemVindo();
            String login = menuLogin();
            if (login.equals(Constantes.LOGIN_FALSE)) {

            } else {
                System.out.println(Constantes.LOGIN_NAO_ENCONTRADO);
            }

        }

    }

}
