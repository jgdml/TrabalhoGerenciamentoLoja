package sistema;

import modelo.BaseEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoGenerico<T extends BaseEntity> {
    private static EntityManager em = EMFProducer.getEmf().createEntityManager();

    private Class<T> cl;

    public DaoGenerico(Class<T> cl) {
        this.cl = cl;
    }

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
            printRegistros();
        }

    }

    private List<T> getRegistros(){

        List<T> resultado = em.createQuery(String.format("SELECT x FROM %s x WHERE x.status != '%s'", this.cl.getSimpleName(), Constantes.STATUS_INATIVO)).getResultList();

        return resultado;

    }


    public void printRegistros(){
        List<T> lista = getRegistros();

        for(int i = 0; i<lista.size(); i++){

            System.out.print(i+1+".   ");

            lista.get(i).print();
        }
    }

    public T escolher(){

        List<T> resultado = getRegistros();

        printRegistros();

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
