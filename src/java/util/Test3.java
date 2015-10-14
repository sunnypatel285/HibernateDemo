/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.ecw.dao.FilmDaoImpl;
import com.ecw.pojo.Film;

/**
 *
 * @author sunnyp
 */
public class Test3 {
    
    public static void main(String[] ar){
        FilmDaoImpl fdi = new FilmDaoImpl();
        Film f =fdi.getFilm(1);
        //f.getFilmId();
    }
}
