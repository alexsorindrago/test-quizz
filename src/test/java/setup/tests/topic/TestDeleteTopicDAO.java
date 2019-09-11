package setup.tests.topic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.EMF;
import quizz.alex.daos.TopicDAO;
import quizz.alex.entity.Topic;
import quizz.alex.enums.TopicDifficulty;

import javax.persistence.EntityManager;

public class TestDeleteTopicDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from category").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void deleteTopic() {
        TopicDAO topicDAO = new TopicDAO();
        Topic topic = new Topic();

        topic.setNumberOfQuestions(1);
        topic.setTopicDifficulty(TopicDifficulty.MEDIUM);

        topicDAO.create(topic);

        Topic testDelete = topicDAO.read(topic.getId());
        topicDAO.delete(testDelete);

        Topic verifyDelete = topicDAO.read(topic.getId());
        Assert.assertNull(verifyDelete);
    }
}
