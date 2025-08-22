    package com.example.financemanagement.service;

    import com.example.financemanagement.dto.CategoryDTO;

    public interface CategoryService {
        CategoryDTO createCategory(CategoryDTO categoryDTO);
        CategoryDTO getCategoryById(Long id);
        CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);
        void deleteCategory(Long id);
        CategoryDTO findCategoryByName(String name);
    }
