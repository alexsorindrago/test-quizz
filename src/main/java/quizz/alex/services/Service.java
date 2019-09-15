package quizz.alex.services;

import quizz.alex.daos.AnswerDAO;
import quizz.alex.daos.CategoryDAO;
import quizz.alex.daos.QuestionDAO;
import quizz.alex.daos.TestingDAO;
import quizz.alex.entity.Question;
import quizz.alex.entity.Testing;

import java.util.List;

public class Service {

    CategoryDAO categoryDAO = new CategoryDAO();
    QuestionDAO questionDAO = new QuestionDAO();
    AnswerDAO answerDAO = new AnswerDAO();
    TestingDAO testingDAO = new TestingDAO();

    public Testing createTest() {
        Testing testing = new Testing();

        {
            // TODO: add details to test
        }

        testingDAO.create(testing);

        List<Question> questions = questionDAO.findAll();

        List<Question> randomChosenQuestions = chooseRandom(questions);

        return testing;


    }

    private List<Question> chooseRandom(List<Question> questions) {
        return null;// TODO

    }
}
