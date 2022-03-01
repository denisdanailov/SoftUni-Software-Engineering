
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class _11_Find_by_FirstName {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine().toLowerCase();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE lower(e.firstName) LIKE :name"
                        , Employee.class)
                .setParameter("name",pattern + "%")
                .getResultList();

        for (Employee employee : employees) {
            String format = String.format("%s %s %s - ($%.2f)",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary());

            System.out.println(format);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
