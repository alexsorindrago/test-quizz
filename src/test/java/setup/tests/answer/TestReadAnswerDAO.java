package setup.tests.answer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Answer;

import javax.persistence.EntityManager;

public class TestReadAnswerDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from topic").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void readAnswer() {
        AnswerDAO answerDAO = new AnswerDAO();

        Answer answer = new Answer();
        answer.setText("second answer");
        answer.setValue(3);

        answerDAO.create(answer);

        Answer readTest = answerDAO.read(answer.getId());
        Assert.assertNotNull(readTest);
    }
}
