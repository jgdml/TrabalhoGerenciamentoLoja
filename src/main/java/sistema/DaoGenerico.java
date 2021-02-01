package sistema;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import modelo.BaseEntity;


import javax.persistence.EntityManager;
import java.util.List;

public class DaoGenerico<T extends BaseEntity> {
    private static EntityManager em = EMFProducer.getEmf().createEntityManager();

    public T findId(Class<T> cl, Integer id) {
        return em.find(cl, id);
    }


    public void salvarOuAtualizar(T obj) {
        try {
            em.getTransaction().begin();
            if (obj.getId() == null) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    public void deletar(T obj) {

        if (obj.getStatus() != null) {
            obj.setStatus(Constantes.STATUS_INATIVO);
            salvarOuAtualizar(obj);
        }

    }

    public List<T> getRegistros(Class<T> tipo){

        List<T> resultado = em.createQuery(String.format("SELECT x FROM %s x WHERE x.status != '%s'", tipo.getSimpleName(), Constantes.STATUS_INATIVO)).getResultList();

        return resultado;

    }

    public void printRegistros(List<T> lista){

        for(int i = 0; i<lista.size(); i++){

            System.out.print(i+1+".   ");

            lista.get(i).print();
        }
    }

    public T escolher(Class<T> tipo){

        List<T> resultado = getRegistros(tipo);

        printRegistros(resultado);

        while(true){

            int in = Input.getInt("Escolha um registro:");

            in -= 1;

            if(in > resultado.size() || in < 0){

                System.out.println("Não contém registro tente novamente");
            }
            else{
                return resultado.get(in);
            }
        }
    }
}
