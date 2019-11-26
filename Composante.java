package com.company;

import java.util.ArrayList;
import java.util.List;

public class Composante {
    private Composante parent;
    private List<Composante> enfants;
    private  Cellule valeur;
    private int rank;

    public Composante (Cellule val) {
        valeur=val;
        parent = null;
        enfants = new ArrayList<>();
        this.rank = 1;
    }

    public List<Composante> getEnfants(){
        return  this.enfants;
    }
    public static Composante rechercher (Composante x) {
        if (x.parent != null){
            x.parent = rechercher(x.parent);
            x.parent.enfants.add(x);
            return  x;
        }
        else
            return x;
    }

    public Cellule getValeur(){
        return  this.valeur;
    }

    public static boolean egaux (Composante x, Composante y) {
        return rechercher(x) == rechercher(y);
    }


    public static void union (Composante x, Composante y) {
        x = rechercher(x);
        y = rechercher(y);
        if(x.rank < y.rank){
            x.parent = y;
            y.enfants.add(x);
        }
        else{
            y.parent = x;
            x.rank = x.rank - y.rank + 1;
            x.enfants.add(y);
        }
    }


}
