import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _02_Change_Casing {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query from_town = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = from_town.getResultList();

        for (Town town : resultList) {
            String townName = town.getName();

            if (townName.length() <= 5 ) {
                String toUpper = townName.toUpperCase();
                town.setName(toUpper);

                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
