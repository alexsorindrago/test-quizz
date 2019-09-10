package quizz.alex.daos;

import quizz.alex.entity.Candidate;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

public class CandidateDAO {

    public void create(Candidate candidate) {
        EntityManager em = new EMF().createEM();

        em.getTransaction().begin();
        em.persist(candidate);
        em.getTransaction().commit();
        em.close();
    }

    public Candidate read(int id) {
        EntityManager em = new EMF().createEM();

        em.getTransaction().begin();
        Candidate candidate = em.find(Candidate.class, id);
        em.getTransaction().commit();
        em.close();

        return candidate;
    }

    public void update(Candidate candidate) {
        EntityManager em = new EMF().createEM();

        em.getTransaction().begin();
        Candidate existing = em.find(Candidate.class, candidate.getId());

        if (existing == null) {
            throw new EntityNotFoundException("could not find id " + candidate.getId());
        }
        existing.setEmail(candidate.getEmail());
        existing.setSurname(candidate.getSurname());
        existing.setName(candidate.getName());

        em.getTransaction().commit();
        em.close();
    }

    public void delete(Candidate candidate) {
        EntityManager em = new EMF().createEM();

        em.getTransaction().begin();
        Candidate existing = em.find(Candidate.class, candidate.getId());

        if (existing != null) {
            em.remove(existing);
        }
        em.getTransaction().commit();
        em.close();
    }

}
