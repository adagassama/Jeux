package com.company;

public class Cellule {
    private int score;
    private int couleur;

    public Cellule(int score, int couleur) {
        this.score = score;
        this.couleur = couleur;
    }

    public Cellule(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
