package setup.tests.answer;

import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Answer;

import javax.persistence.EntityManager;

public class TestCreateAnswerDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from answer").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createAnswer() {

        AnswerDAO answerDAO = new AnswerDAO();
        Answer answer = new Answer();

        answer.setText("first answer");
        answer.setValue(5);

        answerDAO.create(answer);
    }
}
