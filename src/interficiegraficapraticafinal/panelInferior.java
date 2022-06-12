/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marcf
 */
public class panelInferior extends JPanel{
    JButton botonMesclar = new JButton();
    JButton botonJugar = new JButton();
    JButton botonReiniciar = new JButton();
    JTextField textoInf = new JTextField();


    public panelInferior(){
        this.setSize(1200, 50);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        initComponents();
    }

    private void initComponents(){
        botonMesclar.setText("Mescla");
        this.add(botonMesclar);
        botonMesclar.setBounds(450,5,100,20);

        botonJugar.setText("Jugar");
        this.add(botonJugar);
        botonJugar.setBounds(550,5,100,20);
        botonJugar.setEnabled(false);

        botonReiniciar.setText("Reinicia");
        this.add(botonReiniciar);
        botonReiniciar.setBounds(650,5,100,20);
        botonReiniciar.setEnabled(false);

        textoInf.setText("Abans de jugar cal barallar!");
        this.add(textoInf);
        textoInf.setBounds(0, 30, 1200, 20);
    }
}
