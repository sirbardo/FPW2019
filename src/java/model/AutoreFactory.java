/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davide
 */
public class AutoreFactory {
    
    private static AutoreFactory singleton;
    
    private AutoreFactory(){
    
    }
    
    public static AutoreFactory getInstance(){
        if(singleton == null){
            singleton = new AutoreFactory();
        }
        
        return singleton;
    }
    
    public List<Autore> getAutori(){
        List<Autore> autori = new ArrayList<>();
        
        Autore dante = new Autore();
        dante.setId(1);
        dante.setNome("Dante");
        dante.setCognome("Alighieri");
        dante.setEmail("dante@gmail.com");
        dante.setPassword("Beatrice");
        autori.add(dante);
        
        Autore manzoni = new Autore();
        manzoni.setId(2);
        manzoni.setNome("Alessandro");
        manzoni.setCognome("Manzoni");
        manzoni.setEmail("manzoni@gmail.com");
        manzoni.setPassword("Monza");
        autori.add(manzoni);
        
        return autori;
    }
    
    public Autore getAutoreById(int id){
        List<Autore> autori = this.getAutori();
        for(Autore a : autori){
            if(a.getId() == id){
                return a;
            }
        }
        
        return null;
    }
    
    public Autore getAutoreByEmailPassword(String email, String password){
        List<Autore> autori = this.getAutori();
        for(Autore a : autori){
            if(a.getEmail().equals(email) && a.getPassword().equals(password)){
                return a;
            }
        }
        
        return null;
    }
}
