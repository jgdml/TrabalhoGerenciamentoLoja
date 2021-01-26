import sistema.EMFProducer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import classes.Estado;


public class Main {

    public static void main(String[] args){

        EntityManagerFactory emf = EMFProducer.getEmf();

        EntityManager em = emf.createEntityManager();

        Estado es = new Estado("Parana", "PR");

        em.getTransaction().begin();

        em.merge(es);

        em.getTransaction().commit();


        em.find(Estado.class, 1);

        System.out.println(es.getNome());



    }
}
