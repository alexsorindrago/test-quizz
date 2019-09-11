package setup.tests.category;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Category;

import javax.persistence.EntityManager;


public class TestCreateCategoryDAO {

    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createCategory() {

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("gigi");

        categoryDAO.create(category);

        // test remove
        Category testRemove = categoryDAO.read(category.getId());
        categoryDAO.delete(testRemove);

        Category verifyRemove = categoryDAO.read(category.getId());
        Assert.assertNull(verifyRemove);

    }
}