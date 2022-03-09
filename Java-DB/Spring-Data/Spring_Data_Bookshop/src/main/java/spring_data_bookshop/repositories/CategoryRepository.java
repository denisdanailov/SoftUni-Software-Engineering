package spring_data_bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_data_bookshop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
