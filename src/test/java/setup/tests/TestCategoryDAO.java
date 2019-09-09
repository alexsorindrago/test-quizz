package setup.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Category;

import javax.persistence.EntityManager;


public class TestCategoryDAO {

    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void testCreateCategory() {

        // create category
        CategoryDAO objectToTest = new CategoryDAO();

        Category category = new Category();
        category.setName("gig");

        // test this
        objectToTest.create(category);

        // test read
        Category toTest = objectToTest.read(1);

        Assert.assertNotNull(objectToTest);

        // test update
        Category updateTest = objectToTest.read(1);

        updateTest.setName("alexandrovich");
        objectToTest.update(updateTest);

        Category verifyUpdate = objectToTest.read(1);
        Assert.assertEquals("alexandrovich", verifyUpdate.getName());

        // test remove
        Category testRemove = objectToTest.read(1);
        objectToTest.delete(testRemove);

        Category verifyRemove = objectToTest.read(1);
        Assert.assertNull(verifyRemove);

    }
}