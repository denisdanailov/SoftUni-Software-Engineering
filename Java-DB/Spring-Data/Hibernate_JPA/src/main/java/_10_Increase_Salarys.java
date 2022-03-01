
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class _10_Increase_Salarys {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultStream()
                .forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultStream().forEach(employee -> {
                    String format = String.format("%s %s ($%.2f)",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getSalary());

                    System.out.println(format);
        });


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
