package testes;

import sistema.EMFProducer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Inserts {

    public static void init(){

        EntityManagerFactory emf = EMFProducer.getEmf();
        EntityManager em = emf.createEntityManager();

    }
}
