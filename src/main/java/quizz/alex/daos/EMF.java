package quizz.alex.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
    //Entity Manager Factory
    // persistence unit name must match unit name specified in persistence.xml file
    private static final String PERSISTENCE_UNIT_NAME = "examplePersistenceUnit";
    protected static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager createEM() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
