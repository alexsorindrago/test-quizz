package setup.tests.question;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.daos.QuestionDAO;
import quizz.alex.entity.Category;
import quizz.alex.entity.Question;
import quizz.alex.enums.QuestionDifficulty;
import quizz.alex.enums.QuestionType;

import javax.persistence.EntityManager;

public class TestCreateQuestionDAO {

    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from question").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createQuestion() {
        CategoryDAO categoryDAO = new CategoryDAO();
        QuestionDAO questionDAO = new QuestionDAO();

        Category category = new Category();
        category.setName("alex");
        categoryDAO.create(category);

        Question question = new Question();
        question.setText("theQuestion");
        question.setQuestionType(QuestionType.OPEN);
        question.setQuestionDifficulty(QuestionDifficulty.LOW);
        question.setCategory(category);

        questionDAO.create(question);

        // test remove
        Question testRemove = questionDAO.read(question.getId());
        questionDAO.delete(testRemove);

        Question verifyRemove = questionDAO.read(question.getId());
        Assert.assertNull(verifyRemove);
    }
}
