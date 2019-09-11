package quizz.alex.daos;

import quizz.alex.entity.Topic;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class TopicDAO {

    public void create(Topic topic) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        em.persist(topic);
        em.getTransaction().commit();
        em.close();
    }

    public Topic read(int id) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        Topic topic = em.find(Topic.class, id);
        em.getTransaction().commit();
        em.close();

        return topic;
    }

    public void update(Topic topic) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();

        Topic existing = em.find(Topic.class, topic.getId());

        if (existing == null) {
            throw new EntityNotFoundException("could not find topic");
        }
        existing.setNumberOfQuestions(topic.getNumberOfQuestions());
        existing.setTopicDifficulty(topic.getTopicDifficulty());

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Topic topic) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();

        Topic existing = em.find(Topic.class, topic.getId());

        if (existing != null) {
            em.remove(existing);
        }
        em.getTransaction().commit();
        em.close();
    }
}
