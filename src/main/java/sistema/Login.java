package sistema;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class Login {
    private static final EntityManager em = EMFProducer.getEmf().createEntityManager();


    public static String buscarLogin(String login, String senha){

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
    private static String validaLogin(Usuario usuario){

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

}
