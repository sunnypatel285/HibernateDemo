/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecw.pojo;

/**
 *
 * @author sunnyp
 */
public enum Rating {

    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private String value;

    private Rating(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value; //will return , or ' instead of COMMA or APOSTROPHE
    }
}
