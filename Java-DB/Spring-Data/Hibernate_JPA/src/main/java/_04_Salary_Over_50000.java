
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class _04_Salary_Over_50000 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e.firstName FROM Employee e" +
                " WHERE e.salary > 50000",
                        String.class).getResultList().forEach(System.out::println);




        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
