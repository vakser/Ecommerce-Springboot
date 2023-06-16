package com.ecommerce.library.service;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

    Category findById(long id);

    Category update(Category category);

    void deleteById(long id);
    void enableById(long id);

    List<Category> findAllByActivated();

    List<CategoryDto> getCategoryAndProduct();
}
