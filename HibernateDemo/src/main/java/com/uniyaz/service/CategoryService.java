package com.uniyaz.service;

import com.uniyaz.dao.impl.CategoryImpl;
import com.uniyaz.entity.Category;

public class CategoryService {

    private final CategoryImpl categorImpl;

    public CategoryService() {
        categorImpl = new CategoryImpl();
    }

    public Category saveCategory(Category category) {
        return categorImpl.addCategory(category);
    }

    public Category updateCategory(Category category) {
        return categorImpl.updateCategory(category);
    }

    public Boolean deleteCategory(Long id) {
        return categorImpl.deleteCategory(id);
    }


}
