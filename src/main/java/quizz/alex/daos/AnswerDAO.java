package quizz.alex.daos;

import quizz.alex.entity.Answer;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class AnswerDAO {

    public void create(Answer answer) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        em.persist(answer);
        em.getTransaction().commit();
        em.close();
    }

    public Answer read(int id) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        Answer answer = em.find(Answer.class, id);
        em.getTransaction().commit();
        em.close();

        return answer;
    }

    public void update(Answer answer) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();

        Answer existing = em.find(Answer.class, answer.getId());

        if (existing == null) {
            throw new EntityNotFoundException("value not found");
        }
        existing.setText("value text");
        existing.setValue(answer.getValue());

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Answer answer) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();

        Answer existing = em.find(Answer.class, answer.getId());

        if (existing != null) {
            em.remove(existing);
        }
        em.getTransaction().commit();
        em.close();

    }
}
