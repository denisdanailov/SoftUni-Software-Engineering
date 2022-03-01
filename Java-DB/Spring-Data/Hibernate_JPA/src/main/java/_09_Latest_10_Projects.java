
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class _09_Latest_10_Projects {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager
                .createQuery("SELECT p FROM Project AS p" +
                                " ORDER BY p.name ASC ",
                        Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(project -> {
                    String format = String.format("Project name: %s\n" +
                                    "Project Description: %s\n" +
                                    "Project Start Date: %s\n" +
                                    "Project End Date: %s",
                            project.getName(),
                            project.getDescription(),
                            project.getStartDate(),
                            project.getEndDate());

                    System.out.println(format);

                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
