package com.uniyaz;

import com.uniyaz.entity.Category;
import com.uniyaz.service.CategoryService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Category category = new Category();
        category.setName("Deneme Category");

        CategoryService categoryService = new CategoryService();

        categoryService.saveCategory(category);
        System.out.println( "Hello World!" );
    }
}
