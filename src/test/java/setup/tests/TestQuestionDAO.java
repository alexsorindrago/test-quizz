package setup.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.EMF;
import quizz.alex.daos.QuestionDAO;
import quizz.alex.entity.Question;
import quizz.alex.enums.QuestionDifficulty;
import quizz.alex.enums.QuestionType;

import javax.persistence.EntityManager;

public class TestQuestionDAO {

    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from question").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void testCreateQuestion() {
        QuestionDAO questionDAO = new QuestionDAO();

        Question question = new Question();
        question.setText("theQuestion");
        question.setQuestionType(QuestionType.OPEN);
        question.setQuestionDifficulty(QuestionDifficulty.LOW);

        // test create question
        questionDAO.create(question);

        // test read question
        Question toTest = questionDAO.read(question.getId());
        Assert.assertNotNull(toTest);

        // test update
        Question updateTest = questionDAO.read(question.getId());

        updateTest.setText("alexandrovich");
        questionDAO.update(updateTest);


        Question verifyUpdate = questionDAO.read(question.getId());
        Assert.assertEquals("alexandrovich", verifyUpdate.getText());


        // test remove
        Question testRemove = questionDAO.read(question.getId());
        questionDAO.delete(testRemove);

        Question verifyRemove = questionDAO.read(question.getId());
        Assert.assertNull(verifyRemove);
    }
}
