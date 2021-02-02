package sistema;

import modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class Login {
    private static final EntityManager em = EMFProducer.getEmf().createEntityManager();


    public static Usuario buscarLogin(String login, String senha){

        String jpql = String.format("SELECT x FROM Usuario x WHERE x.status != '%s' AND x.login = '%s' AND x.senha = '%s'", Constantes.STATUS_INATIVO, login, senha);

        List<Usuario> res = em.createQuery(jpql).getResultList();


        try{
            return res.get(0);
        }
        catch(IndexOutOfBoundsException err){
            return new Usuario();
        }

    }

}
