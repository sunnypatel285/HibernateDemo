/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

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
public class StoreDaoImpl implements StoreDao{

    SessionFactory sf = NewHibernateUtil.getSessionFactory();
    @Override
    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<Store>();
        Session s = sf.openSession();
        Query q = s.createQuery("select s from Store s, Staff st, Address a, City c, Country co "
                + "where s.staff.staff_id=st.staff_id AND s.address.addressId=a.addressId AND a.city.cityId=c.cityId AND c.country.countryId=co.countryId");
        stores = q.list();
        return stores;
    }
    
    public int addStore(Store store){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(store);
        tx.commit();
        s.close();
        return store.getStoreId();
    }
}
