/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.ecw.dao.ActorDaoImpl;
import com.ecw.dao.FilmActorDao;
import com.ecw.dao.FilmDaoImpl;
import com.ecw.dao.LanguageDaoImpl;
import com.ecw.dao.StoreDaoImpl;
import com.ecw.pojo.Actor;
import com.ecw.pojo.Film;
import com.ecw.pojo.FilmActor;
import com.ecw.pojo.Language;
import com.ecw.pojo.Rating;
import com.ecw.pojo.Store;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sunnyp
 */
public class Test {
    
    public static void main(String[] args){
        List<Actor> ac = new ArrayList<Actor>();
        ActorDaoImpl acDao = new ActorDaoImpl();
        ac = acDao.getAllActors();
        System.out.println(ac.size());
        Actor a = ac.get(10);
        System.out.println(a);
        System.out.println(acDao.getActorById(16));
        
//        Actor a1 = new Actor();
//        a1.setFirstName("Sunny");
//        a1.setLastName("Patel");
//        a1.setLastUpdate(new Date());
//        
//        acDao.addActor(a1);
        
        List<Store> objs = new StoreDaoImpl().getAllStores();
//        Iterator it = objs.iterator();
//        for(Store object : objs){
//            System.out.print(object.getStaff().getFirstName());
//            System.out.println(object.getAddress().getAddress());
//            System.out.print(object.getAddress().getCity().getCity());
//            System.out.println(object.getAddress().getCity().getCountry().getCountry());
//        }
        
        Set set = new HashSet();
        set.add("Trailors");
        Language lan = new LanguageDaoImpl().getLanguage("English");
        //Film f = new Film("Gadar", "Gadar Test", 2002, lan, null, 3, 2.49, 126, 10.56, Rating.NC17, null, new Date());
        //new FilmDaoImpl().addFilm(f);
        Film f = new FilmDaoImpl().getFilm(1);
        System.out.println(f.getDescription());
        System.out.println(f.getActors().size());
//        for(FilmActor fa : f.getActors()){
//            System.out.println(fa.getFilm().getDescription());
//        }
        Actor actor = new ActorDaoImpl().getActorById(15);
        FilmActor fa = new FilmActor();
        fa.setActor(actor);
        fa.setFilm(f);
        //f.getActors().add(fa);
        //new FilmActorDao().addFilmActor(fa);
        //new FilmActorDao().deleteFilmActor(fa);
    }
}
