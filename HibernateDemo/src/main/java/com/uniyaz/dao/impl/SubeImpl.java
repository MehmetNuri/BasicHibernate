package com.uniyaz.dao.impl;

import com.uniyaz.entity.Category;
import com.uniyaz.entity.Sube;
import com.uniyaz.helper.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SubeImpl {

    public List<Sube> findAllCategory() {

        List<Sube> subeList = new ArrayList<Sube>();
        try {
            Session session = HibernateHelper.getSessionFactory().openSession();
            String hql = "Select sube From Sube sube  LEFT JOIN  sube.sirket sirket";
            Query query = session.createQuery(hql);
            subeList = query.list();
            return subeList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
