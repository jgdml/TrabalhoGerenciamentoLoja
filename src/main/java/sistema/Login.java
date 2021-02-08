package sistema;

import infra.EMFProducer;
import modelo.Usuario;


import javax.persistence.EntityManager;
import java.util.List;

public class Login {

    //Função que conecta no banco
    private EntityManager getEntityManager(){
        return EMFProducer.getEmf().createEntityManager();
    }

    //Função que desconecta no banco
    private void closeEntityManager(EntityManager e){
        if (e.isOpen()){
            e.close();
        }
    }

    public String buscarLogin(String login, String senha){
        EntityManager em = getEntityManager();
        String jpql = String.format("SELECT x FROM Usuario x WHERE x.status != '%s' AND x.login = '%s' AND x.senha = '%s'", Constantes.STATUS_INATIVO, login, senha);

        List<Usuario> res = em.createQuery(jpql).getResultList();

        closeEntityManager(em);
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

        if(usuario.getLogin() != null){
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
