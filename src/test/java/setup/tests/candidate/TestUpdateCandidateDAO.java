package setup.tests.candidate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quizz.alex.daos.CandidateDAO;
import quizz.alex.daos.EMF;
import quizz.alex.entity.Candidate;

import javax.persistence.EntityManager;

public class TestUpdateCandidateDAO {
    @Before
    public void delete() {
        EntityManager entityManager = EMF.createEM();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from candidate").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void updateCandidate() {
        CandidateDAO candidateDAO = new CandidateDAO();

        Candidate candidate = new Candidate();
        candidate.setEmail("alex@dragomir.com");
        candidate.setSurname("Dragomir");
        candidate.setName("Alex");

        candidateDAO.create(candidate);

        Candidate updateTest = candidateDAO.read(candidate.getId());
        updateTest.setName("mihai");
        candidateDAO.update(updateTest);

        Candidate verifyUpdate = candidateDAO.read(candidate.getId());
        Assert.assertEquals("mihai", verifyUpdate.getName());
    }
}
