package spring_data_bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_data_bookshop.entities.Author;
import spring_data_bookshop.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByReleaseDateAfter(LocalDate releaseDate);

    int countByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findByBooksWithAuthor(Author author);
}
