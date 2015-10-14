/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Actor;
import com.ecw.pojo.Film;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author sunnyp
 */
public class FilmDaoImpl {
    SessionFactory sf = NewHibernateUtil.getSessionFactory();
    public void addFilm(Film film) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(film);
        tx.commit();
        s.close();
    }
    
    public Film getFilm(int id) {
        Film f = new Film();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Film q = (Film)s.get(Film.class, id);
        //q = (Film)s.load(Film.class, id);
        tx.commit();
        //s.close();
        return q;
    }
}
