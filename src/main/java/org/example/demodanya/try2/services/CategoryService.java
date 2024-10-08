package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Categories;
import org.example.demodanya.try2.models.FullCategoryInfoProjection;

import java.util.List;

public interface CategoryService {
    void addCategory(String name);

    List<FullCategoryInfoProjection>getFullCategoryInfoProjectionByPublisher(String name);
}
