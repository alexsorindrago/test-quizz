package setup.tests.topic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.EMF;
import quizz.alex.daos.TopicDAO;
import quizz.alex.entity.Topic;
import quizz.alex.enums.TopicDifficulty;

import javax.persistence.EntityManager;

public class TestCreateTopicDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from topic").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createTopic() {

        TopicDAO topicDAO = new TopicDAO();
        Topic topic = new Topic();

        topic.setNumberOfQuestions(1);
        topic.setTopicDifficulty(TopicDifficulty.LOW);

        topicDAO.create(topic);

        Assert.assertNotNull(topic);

    }
}
