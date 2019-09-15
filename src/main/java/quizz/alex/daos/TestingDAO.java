package quizz.alex.daos;

import quizz.alex.entity.Testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class TestingDAO {

    public void create(Testing test) {
        EntityManager entityManager = EMF.createEM();

        entityManager.getTransaction().begin();
        entityManager.persist(test);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Testing read(int id) {
        EntityManager entityManager = EMF.createEM();

        entityManager.getTransaction().begin();
        Testing test = entityManager.find(Testing.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();

        return test;
    }

    public void update(Testing test) {
        EntityManager entityManager = EMF.createEM();

        entityManager.getTransaction().begin();
        Testing existing = entityManager.find(Testing.class, test.getId());

        if (existing == null) {
            throw new EntityNotFoundException("test not found");
        }

        existing.setDate(test.getDate());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Testing test) {
        EntityManager entityManager = EMF.createEM();

        entityManager.getTransaction().begin();
        Testing existing = entityManager.find(Testing.class, test.getId());

        if (existing != null) {
            entityManager.remove(existing);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
