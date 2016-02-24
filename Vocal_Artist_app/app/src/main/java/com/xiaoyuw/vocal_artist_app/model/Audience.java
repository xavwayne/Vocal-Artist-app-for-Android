/*
 * Andrew ID: xiaoyuw
 */
package com.xiaoyuw.vocal_artist_app.model;

/**
 *   Audience class-- Audience definition class
 */
public class Audience {
    private String name;
    private String email;

    public Audience(String name, String email){
        this.name=name;
        this.email=email;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}
