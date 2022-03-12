package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a task from 1 to 10");

        int taskNumber = Integer.parseInt(scanner.nextLine());

        switch (taskNumber) {
            case (1) -> {
                bookTitleByAgeRestriction_01(scanner);
            }
            case (2) -> {
                goldenBooks_02();
            }
            case (3) -> {
                booksByPrice_03();
            }
            case (4) -> {
                notReleasedBooks_04(scanner);
            }
            case (5) -> {
                booksReleasedBeforeDate_05(scanner);

            }
            case (6) -> {
                authorsSearch_06(scanner);
            }
            case (7) -> {
                booksSearch_07(scanner);
            }
            case (8) -> {
                bookTitlesSearch_08(scanner);
            }
            case (9) -> {
                countBooks_09(scanner);
            }
            case (10) -> {
                totalBookCopies_10();
            }
            case (11) -> {
                reducedBook_11(scanner);

            }

            default -> throw new IllegalStateException("Unexpected task number: " + taskNumber);
        }

//
    }

    private void reducedBook_11(Scanner scanner) {
        System.out.println("Select title");
        String title = scanner.nextLine();
        BookSummary summary = this.bookService.getInformationForTitle(title);

        System.out.println(summary.getTitle() + " " + summary.getAgeRestriction() + " " + summary.getPrice());
    }

    private void totalBookCopies_10() {
        this.authorService.totalSumOfBookCopies().forEach(a -> System.out.println(
                a.getFirstName() + " " + a.getLastName() + " - " + a.getTotalCopies()
        ));
    }

    private void countBooks_09(Scanner scanner) {
        System.out.println("Program return the number of books, whose title is longer than a given number.");
        System.out.println("Select size");
        int length = Integer.parseInt(scanner.nextLine());
        int totalBooks = this.bookService.countBooksWithTitleLongerThan(length);
        System.out.printf("There are %d books with longer title than %d symbols", totalBooks, length);
    }

    private void bookTitlesSearch_08(Scanner scanner) {
        System.out.println("Program return the title of books, which are written by authors, whose last name starts with a given String");
        System.out.println("-> Select a String");

        String startWith = scanner.nextLine();

        this.bookService.findBookByAuthorLastName(startWith).forEach(book ->
                System.out.println(book.getTitle() + " " +
                        "(" + book.getAuthor().getFirstName() + " " +
                        book.getAuthor().getLastName() + ")"));
    }

    private void booksSearch_07(Scanner scanner) {
        System.out.println("Program return the title of books, which contain a given String");
        System.out.println("-> Select a String");
        String letter = scanner.nextLine();
        this.bookService.findBooksWithTitleContains(letter).forEach(book -> System.out.println(book.getTitle()));
    }

    private void authorsSearch_06(Scanner scanner) {
        System.out.println("Program return Author first Name ends with a given String");
        System.out.println("-> Select a String");
        String endWith = scanner.nextLine();
        this.authorService.findByFirstNameEndingWith(endWith)
                .stream()
                .map(author -> author.getFirstName() + " " + author.getLastName())
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate_05(Scanner scanner) {
        System.out.println("Select a date");
        String date = scanner.nextLine();
        this.bookService.findBooksBefore(date)
                .forEach(book -> {
                    System.out.printf("%s %s %.2f\n", book.getTitle(), book.getEditionType(), book.getPrice());
                });
    }

    private void notReleasedBooks_04(Scanner scanner) {
        System.out.println("Select a Year");
        int year = Integer.parseInt(scanner.nextLine());
        this.bookService.findNotReleaseIn(year)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void booksByPrice_03() {
        this.bookService.findAllWithPriceBetween(5, 40).forEach(book ->
                System.out.println(book.getTitle() + " " + book.getPrice()));
    }

    private void goldenBooks_02() {
        this.bookService.findAllBookTitlesByEditionTypeAndCopies(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void bookTitleByAgeRestriction_01(Scanner scanner) {
        System.out.println("Select a Age Restriction");
        String ageRestriction = scanner.nextLine();
        this.bookService.findAllTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
