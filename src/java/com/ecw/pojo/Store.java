/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sunnyp
 */
@Entity
@Table(name = "store")
public class Store implements Serializable{

    public Store() {
    }

    public Store(Staff staff, Address address, Date lastUpdate) {
        this.staff = staff;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }
    
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storeId;
    
    @JoinColumn(name = "manager_staff_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Staff staff;
    
    @JoinColumn(name = "address_id")
    @ManyToOne
    private Address address;
    
    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
