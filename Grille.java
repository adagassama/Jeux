package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grille {
    private int n;
    private int k;
    private Composante[][] matrice;

    public Grille(){
        remplirGrilleAleatoire();
    }
    public void remplirGrilleAleatoire(){
        Random aleatoire=new Random();
        n=1+aleatoire.nextInt(10);
        k=1+ aleatoire.nextInt(10);
        matrice=new Composante[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrice[i][j]= new Composante(new Cellule(1+ aleatoire.nextInt(k),0));
            }
        }
    }
    public void remplirGrilleFichier(){
        BufferedReader reader;
        try {
            reader=new BufferedReader(new FileReader("/home/adamagassama/Documents/JeuConnexion/src/com/company/grille.txt"));
            String ligne=reader.readLine();
            if (ligne!=null){
                String []valeurs=ligne.split(" ");
                n=Integer.parseInt(valeurs[0]);
                k=Integer.parseInt(valeurs[1]);

                int i=0;
                Composante [][]tab=new Composante[n][n];
                ligne=reader.readLine();
                while (i<n && ligne!=null){
                    valeurs=ligne.split(" ");
                    for(int j=0;j<n;j++){
                        Composante cel = new Composante(new Cellule(Integer.parseInt(valeurs[j])));
                        tab[i][j] = cel;
                    }
                    ligne=reader.readLine();
                    i++;
                }
                i=0;
                while (i<n && ligne!=null){
                    valeurs=ligne.split(" ");
                    for(int j=0;j<n;j++){
                        tab[i][j].getValeur().setCouleur(Integer.parseInt(valeurs[j]));
                    }
                    ligne=reader.readLine();
                    i++;
                }
                this.matrice = tab;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void colorerCase(int x, int y, int c){
        matrice[y][x].getValeur().setCouleur(c);
    }
    public List<Composante> getTousEnfant(Composante comp){
        List<Composante> resultat = new ArrayList<>();
        resultat.add(comp);
        List<Composante> listEnfant = comp.getEnfants();
        for (int i = 0; i < listEnfant.size(); i++) {
            resultat.addAll(getTousEnfant(listEnfant.get(i)));
        }
        return resultat;
    }
    public void AfficherComposante(int x, int y){
        Composante cellule= Composante.rechercher(matrice[y][x]);
        List<Composante> composantes = getTousEnfant(cellule);
        for (int i = 0; i <composantes.size(); i++) {
            String str = composantes.get(i).getValeur().getScore() + "";
            if(composantes.get(i).getValeur().getCouleur() == 1)
                str += "R";
            else
                str += "B";
            System.out.print(str + "\t");
        }

    }
    public  void AfficherScore(int x, int y){
        Composante cellule= Composante.rechercher(matrice[y][x]);
        List<Composante> composantes = getTousEnfant(cellule);
        int score = 0;
        for (int i = 0; i < composantes.size(); i++) {
            score += composantes.get(i).getValeur().getScore();
        }
        System.out.println("Le score est : " + score);
    }

    public Boolean ExisteCheminCases(int x1, int y1, int x2, int y2){
        Composante cellule1 = Composante.rechercher(matrice[y1][x1]);
        Composante cellule2 = Composante.rechercher(matrice[y2][x2]);

        return Composante.egaux(cellule1, cellule2);
    }

    public boolean RelierComposante(int x, int y, int c){
        int cpt = 0;
        if(x-1 >= 0 && (matrice[y][x-1].getValeur().getCouleur() == c)){
            cpt++;
        }
        if(x+1< this.n && matrice[y][x+1].getValeur().getCouleur() == c)
            cpt++;

        if( y-1 >= 0 && matrice[y-1][x].getValeur().getCouleur() == c )
            cpt++;

        if(y+1< this.n && matrice[y+1][x].getValeur().getCouleur() == c)
            cpt++;

        return cpt > 1;
    }
    public void JouerDeuxHumains(){

    }

    public void afficherGrille(){
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                String str = matrice[i][j].getValeur().getScore() + "";
                if(matrice[i][j].getValeur().getCouleur() == 1){
                    str += "R";
                }
                else if(matrice[i][j].getValeur().getCouleur() == 2){
                    str += "B";
                }
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }


}
