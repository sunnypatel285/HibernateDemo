/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author sunnyp
 */
@Entity
@Table(name = "film_actor")
@AssociationOverrides({
    @AssociationOverride(name = "pk.film", joinColumns = @JoinColumn(name = "film_id")),
    @AssociationOverride(name = "pk.actor", joinColumns = @JoinColumn(name = "actor_id"))
})
public class FilmActor implements Serializable {

    private FilmActorId pk = new FilmActorId();

    private Date lastUpdate;

    @Id
    @EmbeddedId
    public FilmActorId getPk() {
        return pk;
    }

    public void setPk(FilmActorId pk) {
        this.pk = pk;
    }

    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Transient
    public Actor getActor() {
        return getPk().getActor();
    }

    public void setActor(Actor actor) {
        getPk().setActor(actor);
    }

    @Transient
    public Film getFilm() {
        return getPk().getFilm();
    }

    public void setFilm(Film film) {
        getPk().setFilm(film);
    }
}
