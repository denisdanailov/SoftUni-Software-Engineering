
import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class _08_Emp_WIth_Project {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        entityManager
                .createQuery("SELECT e FROM Employee AS e" +
                                " WHERE e.id = :id" +
                                " ORDER BY e.firstName ASC",
                        Employee.class)
                .setParameter("id",employeeId)
                .getResultStream()
                .forEach(e -> {
                    String format = String.format("%s %s - %s %s",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            e.getProjects().toString().replaceAll("(^\\[|\\]$)", ""));

                    System.out.println(format);

                });


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
