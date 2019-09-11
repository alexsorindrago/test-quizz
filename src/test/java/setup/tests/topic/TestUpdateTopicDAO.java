package setup.tests.topic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.EMF;
import quizz.alex.daos.TopicDAO;
import quizz.alex.entity.Topic;
import quizz.alex.enums.TopicDifficulty;

import javax.persistence.EntityManager;

public class TestUpdateTopicDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from topic").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void updateTopic() {
        TopicDAO topicDAO = new TopicDAO();
        Topic topic = new Topic();

        topic.setNumberOfQuestions(4);
        topic.setTopicDifficulty(TopicDifficulty.HIGH);

        topicDAO.create(topic);

        Topic updateTest = topicDAO.read(topic.getId());
        updateTest.setNumberOfQuestions(2);
        topicDAO.update(updateTest);

        Topic verifyUpdate = topicDAO.read(topic.getId());
        Assert.assertEquals(2, verifyUpdate.getNumberOfQuestions());
    }
}
