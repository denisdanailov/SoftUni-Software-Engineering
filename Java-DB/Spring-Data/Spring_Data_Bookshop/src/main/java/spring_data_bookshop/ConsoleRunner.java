package spring_data_bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_data_bookshop.entities.Author;
import spring_data_bookshop.entities.Book;
import spring_data_bookshop.repositories.AuthorRepository;
import spring_data_bookshop.repositories.BookRepository;
import spring_data_bookshop.services.SeedService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository booksRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository booksRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAuthors();
//            this.seedService.seedCategories();
//            this.seedService.seedBooks();

//        this.booksAfter2000();
//        this.authorsWithBookBefore1990();
//        this.allAuthorsOrderByBookCount();
            this.booksWithAuthor();
    }

    private void booksWithAuthor() {
        List<Book> books = this.booksRepository.findAll();

        Author authorGP = new Author("George", "Powell");

        books.stream()
                .filter(a -> !a.getAuthor().equals(authorGP))
                .forEach( auth -> System.out.printf("%s", auth.getTitle()));


//    private void allAuthorsOrderByBookCount() {
//        List<Author> authors = this.authorRepository.findAll();
//
//        authors.
//                stream()
//                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
//                .forEach(author -> System.out.printf("%s %s -> %d%n",
//                        author.getFirstName(),
//                        author.getLastName(),
//                        author.getBooks().size()));
//
//    }
//
//    private void authorsWithBookBefore1990() {
//        LocalDate year1990 = LocalDate.of(1990, 1, 1);
//        List<Author> authors = this.authorRepository.findByBooksReleaseDateBefore(year1990);
//
//        authors.forEach(author -> System.out.println(
//                author.getFirstName()
//                        + " " +
//                        author.getLastName()));
//
//    }
//
//    private void booksAfter2000() {
//        LocalDate year2000 = LocalDate.of(2000, 12, 31);
//        List<Book> books = booksRepository.findByReleaseDateAfter(year2000);
//
//        books.stream().forEach(book -> System.out.println(book.getTitle()));
//
//        int count = this.booksRepository.countByReleaseDateAfter(year2000);
//        System.out.println("Total count: " + count);
    }
}
