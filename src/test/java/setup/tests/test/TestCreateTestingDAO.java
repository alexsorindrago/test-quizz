package setup.tests.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.EMF;
import quizz.alex.daos.TestingDAO;
import quizz.alex.entity.Testing;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCreateTestingDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from test").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createTest() throws ParseException {
        TestingDAO testingDAO = new TestingDAO();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
        Date date = simpleDateFormat.parse("24-08-2019");

        Testing test = new Testing();
        test.setDate(date);

        testingDAO.create(test);

        Assert.assertNotNull(test);

    }
}
