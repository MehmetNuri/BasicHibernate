package com.uniyaz.dao.impl;

import com.uniyaz.dao.CategoryDao;
import com.uniyaz.entity.Category;
import com.uniyaz.helper.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements CategoryDao {

    @Override
    public Category addCategory(Category category) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return category;
    }

    @Override
    public List<Category> findAllCategory() {

        List<Category> categoryList = new ArrayList<Category>();
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            String hql = "Select category From Category category";
            Query query = session.createQuery(hql);
            categoryList = query.list();
            return categoryList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteCategory(Long id) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            String hql = "Delete From Category category Where category.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            if (result > 0) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public void deleteCategoryTwo(Category category) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction =  session.beginTransaction();
            session.delete(category);
            transaction.commit();
            session.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Category updateCategory(Category category) {
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Category selectedCategory =  session.get(Category.class,category.getId());
            selectedCategory.setName(category.getName());
            session.update(selectedCategory);
            transaction.commit();
            session.close();
            return selectedCategory;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
