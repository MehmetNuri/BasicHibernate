package com.uniyaz.dao;

import com.uniyaz.entity.Category;

import java.util.List;

public interface CategoryDao {

    public Category addCategory(Category category);

    public List<Category> findAllCategory();

    public Boolean deleteCategory(Long id);

    public Category updateCategory(Category category);

}
