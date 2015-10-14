/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Staff;
import com.ecw.pojo.Store;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author sunnyp
 */
public class StaffDaoImpl {
    SessionFactory sf = NewHibernateUtil.getSessionFactory();

    public int addStStaff(Staff staff){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(staff);
        tx.commit();
        s.close();
        return staff.getStaff_id();
    }
    
    public Staff getStaff(int id){
        Staff st = new Staff();
        Session s = sf.openSession();
        Criteria cr = s.createCriteria(Staff.class);
        cr.add(Restrictions.eq("staff_id", id));
        st = (Staff)cr.uniqueResult();
        return st;
    }
}
