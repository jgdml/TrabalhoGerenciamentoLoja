package infra;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class EMFProducer {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");

    public static EntityManagerFactory getEmf(){
        return emf;
    }

    public static void close(){
        if (emf.isOpen()){
            emf.close();
        }
    }

}