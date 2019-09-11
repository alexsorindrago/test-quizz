package setup.tests.answer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Answer;

import javax.persistence.EntityManager;

public class TestUpdateAnswerDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from topic").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void updateAnswer() {
        AnswerDAO answerDAO = new AnswerDAO();

        Answer answer = new Answer();
        answer.setText("third answer");
        answer.setValue(2);

        answerDAO.create(answer);

        Answer updateTest = answerDAO.read(answer.getId());
        updateTest.setValue(9);
        answerDAO.update(updateTest);

        Answer verifyUpdate = answerDAO.read(answer.getId());
        Assert.assertEquals(9, verifyUpdate.getValue());


    }
}
