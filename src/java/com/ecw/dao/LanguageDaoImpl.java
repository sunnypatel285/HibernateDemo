/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecw.dao;

import com.ecw.pojo.Language;
import com.ecw.pojo.Store;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author sunnyp
 */
public class LanguageDaoImpl {

    SessionFactory sf = NewHibernateUtil.getSessionFactory();

    public List<Language> getAllStores() {
        List<Language> stores = new ArrayList<Language>();
        Session s = sf.openSession();
        Query q = s.createQuery("from Language");
        stores = q.list();
        return stores;
    }

    public Language getLanguage(String name) {
        Language l = new Language();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.getNamedQuery("findLanguageByName").setParameter("languageName", name);
        l = (Language) q.uniqueResult();
        tx.commit();
        s.clear();
        s.close();
        return l;
    }
}
