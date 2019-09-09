package quizz.alex.daos;

import quizz.alex.entity.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class QuestionDAO {

    public void create(Question question) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();
        em.close();
    }

    public Question read(int id) {
        EntityManager em = EMF.createEM();

        em.getTransaction().begin();
        Question question = em.find(Question.class, id);
        em.getTransaction().commit();
        em.close();

        return question;
    }

    public void update(Question question) {
        EntityManager em = EMF.createEM();
        em.getTransaction().begin();
        Question existing = em.find(Question.class, question.getId());

        if (existing == null) {
            throw new EntityNotFoundException("cannot find id " + question.getId());
        }
        existing.setText(question.getText());
        existing.setQuestionType(question.getQuestionType());
        existing.setQuestionDifficulty(question.getQuestionDifficulty());

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Question question) {
        EntityManager em = EMF.createEM();
        em.getTransaction().begin();

        Question existing = em.find(Question.class, question.getId());

        if (existing != null) {
            em.remove(existing);
        }
        em.getTransaction().commit();
        em.close();
    }


}
