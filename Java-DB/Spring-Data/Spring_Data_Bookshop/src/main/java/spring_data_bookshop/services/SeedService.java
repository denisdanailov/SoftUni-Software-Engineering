package spring_data_bookshop.services;

import java.io.IOException;

public interface SeedService {
    void seedAuthors() throws IOException;

    void seedCategories() throws IOException;

    void seedBooks() throws IOException;

    default void seeAll() throws IOException {
        seedAuthors();
        seedCategories();
        seedBooks();
    }
}
