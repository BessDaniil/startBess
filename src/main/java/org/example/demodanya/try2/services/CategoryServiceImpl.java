package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Categories;
import org.example.demodanya.try2.models.FullCategoryInfoProjection;
import org.example.demodanya.try2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(String name) {
        categoryRepository.save(new Categories(name));
    }

    @Override
    public List<FullCategoryInfoProjection> getFullCategoryInfoProjectionByPublisher(String name) {
        return categoryRepository.getFullCategoryInfoProjectionByPublisher(name);
    }
}
