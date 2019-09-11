package setup.tests.category;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Category;

import javax.persistence.EntityManager;

public class TestDeleteCategoryDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void deleteCategoty() {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("alex");

        categoryDAO.create(category);

        Category testDelete = categoryDAO.read(category.getId());
        categoryDAO.delete(testDelete);

        Category verifyDelete = categoryDAO.read(category.getId());
        Assert.assertNull(verifyDelete);
    }
}
