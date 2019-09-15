package setup.tests.category;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Category;

import javax.persistence.EntityManager;

public class TestReadCategoryDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from answer").executeUpdate();
        entityManager.createNativeQuery("delete from question").executeUpdate();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void readCategory() {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("gigi");

        categoryDAO.create(category);

        Category readTest = categoryDAO.read(category.getId());
        Assert.assertNotNull(readTest);


    }
}
