
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;


public class _05_Employee_from_Department {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String department = "Research and Development";

        List<String> employees = new LinkedList<>();

         entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                            " ORDER BY e.salary ASC, e.id ASC",
                Employee.class)
                 .setParameter("departmentName", department)
                 .getResultStream().forEach(e -> {

                    String format = String.format("%s %s from %s - $%.2f"
                            ,e.getFirstName(),
                            e.getLastName(),
                            e.getDepartment().getName(),
                            e.getSalary());

             employees.add(format);
         });

        for (String employee : employees) {
            System.out.println(employee);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
