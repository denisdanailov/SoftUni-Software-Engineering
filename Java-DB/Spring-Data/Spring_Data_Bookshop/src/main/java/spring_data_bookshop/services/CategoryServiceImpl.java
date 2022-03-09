package spring_data_bookshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_bookshop.entities.Category;
import spring_data_bookshop.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();
        long size = this.categoryRepository.count();

        int categoriesCount = random.nextInt((int) size) + 1;

        Set<Integer> categoriesId = new HashSet<>();

        for (int i = 0; i < categoriesCount; i++) {
            int nextId = random.nextInt((int) size) + 1;

            categoriesId.add(nextId);
        }

        List<Category> allById = this.categoryRepository.findAllById(categoriesId);

        return new HashSet<>(allById);

    }
}
