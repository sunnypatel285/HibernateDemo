/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Actor;
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
public class ActorDaoImpl implements ActorDao{

    SessionFactory sf = NewHibernateUtil.getSessionFactory();
    @Override
    public List<Actor> getAllActors() {
        Session s = sf.openSession();
        List<Actor> actors = new ArrayList<Actor>();
        Query q = s.getNamedQuery("findAllActors");
        actors = q.list();
        s.clear();
        s.close();
        return actors;
    }

    @Override
    public Actor getActorById(int id) {
        Session s = sf.openSession();
        Actor a = new Actor();
        Query q = s.getNamedQuery("findActorById").setInteger("actor_id", id);
        a = (Actor) q.uniqueResult();
        s.close();
        return a;
    }

    @Override
    public void addActor(Actor actor) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(actor);
        tx.commit();
        s.close();
    }
    
}
