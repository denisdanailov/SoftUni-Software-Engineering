package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findAllBookTitlesByEditionTypeAndCopies(EditionType type, int copies);


    List<Book> findAllWithPriceBetween(int lowerBound, int upperBound);

    List<Book> findNotReleaseIn(int year);

    List<Book> findBooksBefore(String date);

    List<Book> findBooksWithTitleContains(String letter);

    List<Book> findBookByAuthorLastName(String startWith);

    int countBooksWithTitleLongerThan(int length);


    BookSummary getInformationForTitle(String title);
}
