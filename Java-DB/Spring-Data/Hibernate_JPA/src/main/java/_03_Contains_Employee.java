
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;


public class _03_Contains_Employee {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String[] name = scanner.nextLine().split("\\s+");
        String firstName = name[0];
        String lastName = name[1];


        Long result = entityManager.createQuery("SELECT COUNT(e) FROM Employee e" +
                " WHERE e.firstName = :first_name" +
        " AND e.lastName = :last_name",
                        Long.class)
                .setParameter("first_name", firstName)
                .setParameter("last_name", lastName).getSingleResult();



        if (result > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
