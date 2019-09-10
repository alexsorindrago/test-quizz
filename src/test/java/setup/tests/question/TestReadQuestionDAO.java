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

public class TestReadQuestionDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from question").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void readQuestion() {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("alex");
        categoryDAO.create(category);

        QuestionDAO questionDAO = new QuestionDAO();
        Question question = new Question();
        question.setText("next question");
        question.setQuestionDifficulty(QuestionDifficulty.LOW);
        question.setQuestionType(QuestionType.OPEN);
        question.setCategory(category);

        questionDAO.create(question);

        Question read = questionDAO.read(question.getId());
        Assert.assertNotNull(read);

    }
}
