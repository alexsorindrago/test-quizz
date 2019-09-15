package setup.tests.answer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.EMF;
import quizz.alex.daos.QuestionDAO;
import quizz.alex.entity.Answer;
import quizz.alex.entity.Category;
import quizz.alex.entity.Question;
import quizz.alex.enums.QuestionDifficulty;
import quizz.alex.enums.QuestionType;

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

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("Java");
        categoryDAO.create(category);

        QuestionDAO questionDAO = new QuestionDAO();
        Question question = new Question();
        question.setText("question 1");
        question.setQuestionType(QuestionType.OPEN);
        question.setQuestionDifficulty(QuestionDifficulty.MEDIUM);
        question.setCategory(category);
        questionDAO.create(question);


        answer.setText("first answer");
        answer.setValue(true);
        answer.setQuestion(question);
        answerDAO.create(answer);

        Answer testDelete = answerDAO.read(answer.getId());
        answerDAO.delete(testDelete);

        Answer verifyDelete = answerDAO.read(answer.getId());
        Assert.assertNull(verifyDelete);
    }
}
