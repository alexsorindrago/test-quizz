package quizz.alex.daos;

import quizz.alex.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class CategoryDAO {

    public void create(Category category) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();

    }

    ;

    public Category read(int id) {
        EntityManager em = EMF.createEM();
        em.getTransaction().begin();
        Category category = em.find(Category.class, 1);
        em.getTransaction().commit();
        em.close();
        return category;
    }

    public void update(Category category) {
        EntityManager em = EMF.createEM();
        em.getTransaction().begin();
        Category existing = em.find(Category.class, category.getId());

        if (existing == null) {
            throw new EntityNotFoundException("cannot find id " + category.getId());
        } else {
            existing.setName(category.getName());
        }

        em.getTransaction().commit();
        em.close();

    }

    // use entity manager remove
    public void delete(Category category) {
        EntityManager em = EMF.createEM();
        em.getTransaction().begin();

        Category existing = em.find(Category.class, category.getId());

        if (existing != null) {
            em.remove(existing);
        }
        em.getTransaction().commit();
        em.close();
    }

}
