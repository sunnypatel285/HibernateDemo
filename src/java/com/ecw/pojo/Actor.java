/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecw.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author sunnyp
 */
@NamedQueries({
    @NamedQuery(name="findAllActors", query = "from Actor a"),
    @NamedQuery(name="findActorById", query = "from Actor a where a.actorId = :actor_id")
})

@Entity
@Table(name = "actor")
public class Actor {

    public Actor() {
    }

    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "actor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    @Type(type = "timestamp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdate;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.film", cascade = CascadeType.ALL)
    Set<FilmActor> films = new HashSet<FilmActor>();

    public Set<FilmActor> getFilms() {
        return films;
    }

    public void setFilms(Set<FilmActor> films) {
        this.films = films;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate + '}';
    }
}
