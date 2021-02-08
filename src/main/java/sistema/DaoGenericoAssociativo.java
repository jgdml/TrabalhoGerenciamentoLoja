package sistema;

import infra.EMFProducer;
import modelo.BaseEntityAssociativa;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoGenericoAssociativo<T extends BaseEntityAssociativa> {

    private final Class<T> cl;

    public DaoGenericoAssociativo(Class<T> cl) {
        this.cl = cl;
    }




    private EntityManager getEntityManager(){
        return EMFProducer.getEmf().createEntityManager();
    }

    private void closeEntityManager(EntityManager e){
        if (e.isOpen()){
            e.close();
        }
    }





    public T findId(Integer id) {
        EntityManager em = getEntityManager();

        T obj = em.find(cl, id);
        closeEntityManager(em);
        return obj;
    }



    public void salvarOuAtualizar(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!obj.keyExists()) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        closeEntityManager(em);
    }


    public void deletar(T obj) {

        if (obj.getStatus() != null) {
            obj.setStatus(Constantes.STATUS_INATIVO);
            salvarOuAtualizar(obj);
            printRegistros();
        }
    }

    private List<T> getRegistros(){
        EntityManager em = getEntityManager();
        List<T> resultado = em.createQuery(String.format("SELECT x FROM %s x WHERE x.status != '%s'", this.cl.getSimpleName(), Constantes.STATUS_INATIVO)).getResultList();

        closeEntityManager(em);
        return resultado;

    }


    public void printRegistros(){
        List<T> lista = getRegistros();
        System.out.println("\n");

        for(int i = 0; i<lista.size(); i++){
            if (i==0){
                lista.get(i).printLegenda();
            }

            System.out.print(i+1+".   ");

            lista.get(i).print();
        }
    }

    public T escolher(){

        List<T> resultado = getRegistros();

        printRegistros();

        while(true){

            int in = Input.getInt(Constantes.REGISTRO_ESCOLHER);

            in -= 1;

            if(in > resultado.size()-1 || in < 0){

                System.out.println(Constantes.REGISTRO_NAO_EXISTE);
            }
            else{
                return resultado.get(in);
            }
        }
    }
}
