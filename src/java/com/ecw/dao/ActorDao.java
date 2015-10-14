/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecw.dao;

import com.ecw.pojo.Actor;
import java.util.List;

/**
 *
 * @author sunnyp
 */
public interface ActorDao {
    
    List<Actor> getAllActors();
    Actor getActorById(int id);
    void addActor(Actor actor);
}
