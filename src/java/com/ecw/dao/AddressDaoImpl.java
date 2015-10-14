/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Address;
import com.ecw.pojo.Language;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author sunnyp
 */
public class AddressDaoImpl {
    SessionFactory sf = NewHibernateUtil.getSessionFactory();
    public Address getLanguage(int id) {
        Address l = new Address();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Address where address_id="+id);
        l = (Address) q.uniqueResult();
        tx.commit();
        s.clear();
        s.close();
        return l;
    }
}
