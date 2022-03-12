package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public List<String> findAllTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return this.bookRepository.findByAgeRestriction(restriction);
    }

    @Override
    public List<String> findAllBookTitlesByEditionTypeAndCopies(EditionType type, int copies) {
        return this.bookRepository.findByEditionTypeAndCopiesLessThan(type, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllWithPriceBetween(int lowerBound, int upperBound) {

        BigDecimal lower = BigDecimal.valueOf(lowerBound);
        BigDecimal upper = BigDecimal.valueOf(upperBound);

        return this.bookRepository.findByPriceBetween(lower, upper);
    }

    @Override
    public List<Book> findNotReleaseIn(int year) {
        LocalDate before = LocalDate.of(year,1,1);
        LocalDate after = LocalDate.of(year,12,31);
        return this.bookRepository.findByReleaseDateBeforeOrReleaseDateAfter(before, after);
    }

    @Override
    public List<Book> findBooksBefore(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate before = LocalDate.parse(date, formatter);

        return bookRepository.findByReleaseDateBefore(before);
    }

    @Override
    public List<Book> findBooksWithTitleContains(String letter) {
        return this.bookRepository.findByTitleContaining(letter);
    }

    @Override
    public List<Book> findBookByAuthorLastName(String startWith) {
        return this.bookRepository.findByAuthorLastNameStartingWith(startWith);
    }

    @Override
    public int countBooksWithTitleLongerThan(int length) {
        return this.bookRepository.countBooksWithTitleLongerThan(length);
    }

    @Override
    public BookSummary getInformationForTitle(String title) {
        return this.bookRepository.findSummaryForTitle(title);
    }


    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
