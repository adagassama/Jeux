package com.company;

import javax.swing.*;
import java.awt.*;

public class Jeu extends JFrame {

    public  Jeu(Grille mgrille ){
        //private Grille grille1= new Grille();

        this.setSize(new Dimension(500,600));
        this.setBackground(Color.GRAY);//
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel monlabel = new JLabel("3");
        JLabel monlabel1 = new JLabel("5");
        monlabel.setBounds(0,0,30,30);
        monlabel1.setBounds(31,0,30,30);
        monlabel.setBackground(Color.RED);
        monlabel.setOpaque(true);
        monlabel.setHorizontalAlignment(JLabel.CENTER);
        monlabel.setVerticalAlignment(JLabel.CENTER);
        monlabel.setVisible(true);
        this.add(monlabel);

        monlabel1.setBackground(Color.BLUE);
        monlabel1.setOpaque(true);
        monlabel1.setHorizontalAlignment(JLabel.CENTER);
        monlabel1.setVerticalAlignment(JLabel.CENTER);
        monlabel1.setVisible(true);
        this.add(monlabel1);
    }
}
