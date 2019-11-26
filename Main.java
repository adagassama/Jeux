package com.company;

public class Main {


    public static void main(String[] args) {
         // new Grille();
        // write your code here

//        Grille magrille= new  Grille();
//        Jeu jeu = new Jeu(magrille);
//        jeu.setVisible(true);

        Grille magrille = new Grille();
        magrille.remplirGrilleAleatoire();
        magrille.afficherGrille();
    }
}
