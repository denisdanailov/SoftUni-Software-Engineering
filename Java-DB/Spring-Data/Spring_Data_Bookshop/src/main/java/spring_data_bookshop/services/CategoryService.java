package spring_data_bookshop.services;

import spring_data_bookshop.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

}
