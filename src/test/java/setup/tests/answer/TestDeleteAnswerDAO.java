package setup.tests.answer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Answer;

import javax.persistence.EntityManager;

public class TestDeleteAnswerDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from topic").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void deleteAnswer() {
        AnswerDAO answerDAO = new AnswerDAO();

        Answer answer = new Answer();
        answer.setText("fourth answer");
        answer.setValue(7);

        answerDAO.create(answer);

        Answer testDelete = answerDAO.read(answer.getId());
        answerDAO.delete(testDelete);

        Answer verifyDelete = answerDAO.read(answer.getId());
        Assert.assertNull(verifyDelete);
    }
}
