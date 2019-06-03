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
public class LibroFactory {
    
    private static LibroFactory singleton;
    
    private LibroFactory(){
        
    }
    
    public static LibroFactory getInstance(){
        if(singleton == null){
            singleton = new LibroFactory();
        }
        
        return singleton;
    }
    
    public List<Libro> getLibri(){
        List<Libro> libri = new ArrayList<>();
        
        Libro dc = new Libro();
        dc.setId(1);
        dc.setTitolo("Divina Commedia");
        dc.setTesto("Nel mezzo del cammin di nostra vita...");
        Autore dante = AutoreFactory.getInstance().getAutoreById(1);
        dc.getAutore().add(dante);
        libri.add(dc);
        
        Libro vn = new Libro();
        vn.setId(2);
        vn.setTitolo("Vita Nova");
        vn.setTesto("Tanto bella e tanto onesta pare");
        vn.getAutore().add(dante);
        libri.add(vn);
        
        Libro ps = new Libro();
        ps.setId(3);
        ps.setTitolo("I Promessi Sposi");
        ps.setTesto("Quel ramo del lago di Como...");
        Autore manzoni = AutoreFactory.getInstance().getAutoreById(2);
        ps.getAutore().add(manzoni);
        libri.add(ps);
        
        return libri;
    }
    
    public List<Libro> getLibriAutore(Autore a){
        List<Libro> libriAutore = new ArrayList<>();
        List<Libro> tuttiLibri = this.getLibri();
        
        for(Libro l : tuttiLibri){
            for(Autore a1 : l.getAutore()){
                if(a1.equals(a)){
                    libriAutore.add(l);
                }
            }
        }
        
        return libriAutore;
    }
    

    public List<Libro> searchLibri(String toSearch){
        
        List <Libro> listToReturn = new ArrayList<>();

        for (Libro libro : getLibri()){
            if (libro.getTitolo().contains(toSearch))
                listToReturn.add(libro);
        }

        return listToReturn;
    }

    public Libro getLibroId(int id){
        List<Libro> tuttiLibri = this.getLibri();
        for(Libro l : tuttiLibri){
            if(l.getId() == id){
                return l;
            }
        }
        
        return null;
    }
}
