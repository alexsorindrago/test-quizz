package setup.tests.category;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Category;

import javax.persistence.EntityManager;

public class TestUpdateCategoryDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void updateCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("costel");

        categoryDAO.create(category);

        Category updateTest = categoryDAO.read(category.getId());
        updateTest.setName("alexandru");
        categoryDAO.update(updateTest);

        Category verifyUpdate = categoryDAO.read(category.getId());
        Assert.assertEquals("alexandru", verifyUpdate.getName());


    }
}
