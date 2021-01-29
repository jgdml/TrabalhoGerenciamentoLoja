package sistema;

import modelo.BaseEntity;


import javax.persistence.EntityManager;

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
            obj.setStatus("I");
            salvarOuAtualizar(obj);
        }

    }
}
