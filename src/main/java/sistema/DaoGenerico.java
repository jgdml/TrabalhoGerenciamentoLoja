package sistema;

import modelo.BaseEntity;
import sistema.EMFProducer;

import javax.persistence.EntityManager;

public class DaoGenerico <T extends BaseEntity> {
    private static EntityManager em = EMFProducer.getEmf().createEntityManager();

    public T findId(Class<T> cl, Integer id){
        return em.find(cl, id);
    }

    public void save(T cl){
        em.getTransaction().begin();
        em.merge(cl);
        em.getTransaction().commit();
    }
}
