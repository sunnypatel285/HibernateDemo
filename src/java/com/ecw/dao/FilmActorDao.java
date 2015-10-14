/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Film;
import com.ecw.pojo.FilmActor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author sunnyp
 */
public class FilmActorDao {
    SessionFactory sf = NewHibernateUtil.getSessionFactory();
    public void addFilmActor(FilmActor fa) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(fa);
        tx.commit();
        s.close();
    }
    
    public void deleteFilmActor(FilmActor fa){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.delete(fa);
        tx.commit();
        s.clear();
        s.close();
    }
}
