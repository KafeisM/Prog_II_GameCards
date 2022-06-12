/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marcf
 */
public class InterficieGraficaPracticaFinal extends JFrame{

    Baralla baraja = generarBaralla();
    Jugador jug1 = new Jugador();
    Jugador jug2 = new Jugador();
    Jugador jug3 = new Jugador();
    Jugador jug4 = new Jugador(); 
    Joc tj = new Joc();
    Boolean haGuanyat = false;
    //declaración de los diferentes tableros
    Tablero tauler = new Tablero();
    Tablero taulerM = new Tablero();
    Tablero taulerJoc = new Tablero();
    //declaración de los paneles
    panelInferior pi = new panelInferior();
    BarallaVisualizer bv = new BarallaVisualizer(13);
    BarallaVisualizer bv2 = new BarallaVisualizer(1);
    panelSuperior ps = new panelSuperior();
    //declaración de etiquetas para las puntuaciones
    JLabel etiqJug1 = new JLabel();
    JLabel etiqJug2 = new JLabel();
    JLabel etiqJug3 = new JLabel();
    JLabel etiqPropia = new JLabel();
    
    public InterficieGraficaPracticaFinal(){
        this.setSize(1212, 839);
        this.setLayout(null);
        //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(new Color(42, 100, 25));
        this.setTitle("Joc del 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    
    public static void main(String[] args) {
        InterficieGraficaPracticaFinal g = new InterficieGraficaPracticaFinal();
        g.setVisible(true);
    }

    private void initComponents() {
        //característiques de les etiquetes superiors
        etiqJug1.setText("0");
        etiqJug1.setForeground(Color.white);
        etiqJug1.setFont(new java.awt.Font("Arial", 1, 36));
        this.add(etiqJug1);
        etiqJug1.setBounds(255, 15, 1200/13, 450/4);
        
        etiqJug2.setText("0");
        etiqJug2.setForeground(Color.white);
        etiqJug2.setFont(new java.awt.Font("Arial", 1, 36));
        this.add(etiqJug2);
        etiqJug2.setBounds(570, 15, 1200/13, 450/4);
     
        etiqJug3.setText("0");
        etiqJug3.setForeground(Color.white);
        etiqJug3.setFont(new java.awt.Font("Arial", 1, 36));
        this.add(etiqJug3);
        etiqJug3.setBounds(880, 15, 1200/13, 450/4);
        
        //afegim el panell superior amb les caselles
        this.add(ps);
        ps.setBounds(0,-100,1200,300);
        //posam les fotos de la baralla ordenada i afegim el tauler inicial
        ponerFotosOrden();
        this.add(tauler);       
        tauler.setBounds(0,140, 1200, 500);
        //afegim el tauler amb les cartes mesclades (no visible inicialment)
        this.add(taulerM);
        taulerM.setBounds(0,140, 1200, 500);
        taulerM.setVisible(false);
        //afegim el tauler buid on jugar (no visible inicialment)
        this.add(taulerJoc);
        taulerJoc.setBounds(0,140, 1200, 500);        
        taulerJoc.setVisible(false);
        //configuració de la etiqueta inferior
        etiqPropia.setText("0");
        etiqPropia.setForeground(Color.white);
        etiqPropia.setFont(new java.awt.Font("Arial", 1, 24));
        this.add(etiqPropia);
        etiqPropia.setBounds(42, 590, 50, 50);
        //afegim el visualizer de la baralla inferior (no visible inicialment)
        this.add(bv);
        bv.setBounds(0, 520, 1200, 400);
        bv.setVisible(false);
        //afegim el visualizer de dimensió 1
        this.add(bv2);
        bv2.setBounds(3, 520, 1200, 400);
        //afegim el panell de botons inferior
        this.add(pi);
        pi.setBounds(0, 750, 1200, 50);
        //mètodes de acció
        pi.botonMesclar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonMesclar(evt);
            }
        });
        pi.botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonReiniciar(evt);
            }
        });   
        pi.botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonJugar(evt);
            }
        }); 

        

        
        
    }
    
    
    private void ponerFotosOrden(){ //hecho
        for (int j = 0; j < 13; j++){
            tauler.Posa(baraja.getCarta(j), 0, j);
        }
        
        for (int j = 0; j < 13; j++){
            tauler.Posa(baraja.getCarta(j+13), 1, j);
        }
        
        for (int j = 0; j < 13; j++){
            tauler.Posa(baraja.getCarta(j+26), 2, j);
        }        
       
        for (int j = 0; j < 13; j++){
            tauler.Posa(baraja.getCarta(j+39), 3, j);
        }
        
        
    } 
    
    private void botonMesclar(java.awt.event.ActionEvent e){
        tauler.setVisible(false);
        baraja.mesclar();
        ponerFotosMezcladas();
        //ponerFotosMezcladas();
        taulerM.setVisible(true);
        pi.botonJugar.setEnabled(true);
        pi.botonJugar.setBackground(Color.BLUE);
        pi.botonReiniciar.setEnabled(true);
        pi.textoInf.setText("La baralla està mesclada");
    }
    
    private void botonReiniciar(java.awt.event.ActionEvent e){
        taulerM.setVisible(false);
        tauler.setVisible(true);
        pi.botonJugar.setEnabled(false);
        pi.botonReiniciar.setEnabled(false);
        pi.textoInf.setText("Abans de jugar cal barallar!");
        bv.setVisible(false);
        taulerJoc.setVisible(false);
        pi.botonMesclar.setVisible(true);
        pi.botonJugar.setText("Jugar");
    }
   
    private void ponerFotosMezcladas(){ //hecho
        for (int j = 0; j < 13; j++){
            taulerM.Posa(baraja.getCarta(j), 0, j);
        }
        
        for (int j = 0; j < 13; j++){
            taulerM.Posa(baraja.getCarta(j+13), 1, j);
        }
        
        for (int j = 0; j < 13; j++){
            taulerM.Posa(baraja.getCarta(j+26), 2, j);
        }        
       
        for (int j = 0; j < 13; j++){
            taulerM.Posa(baraja.getCarta(j+39), 3, j);
        }
    }
        
    private static void repartir(Baralla bar, Jugador[] jug) {
        int carta;
        int numJug = 4;
        int numCartes = 13;

        for (int i = 1; i <= numJug; i++) {

            for (int j = 0; j < numCartes; j++) {

                switch (i) {
                    case 1:
                        jug[0].setMunt(bar.repartir(j));
                        break;
                    case 2:
                        carta = j + 13;
                        jug[1].setMunt(bar.repartir(carta));
                        break;
                    case 3:
                        carta = j + 26;
                        jug[2].setMunt(bar.repartir(carta));
                        break;
                    case 4:
                        carta = j + 39;
                        jug[3].setMunt(bar.repartir(carta));
                        break;
                }

            }
        }

    }

    private void mostrarEstadoPartida(){
        Carta[] fila1 = tj.getJocClubs();
        Carta[] fila2 = tj.getJocDiamonds();
        Carta[] fila3 = tj.getJocHearts();
        Carta[] fila4 = tj.getJocSpades();
        
        for(int i = 0; i < 13; i++){
           if (fila1[i] != null){
                taulerJoc.Posa(fila1[i], 0, i);              
           }
 
        }
        for(int i = 0; i < 13; i++){
           if (fila2[i] != null){
                taulerJoc.Posa(fila2[i], 1, i);              
           } 
        }
        for(int i = 0; i < 13; i++){
           if (fila3[i] != null){
                taulerJoc.Posa(fila3[i], 2, i);              
           } 
        }
        for(int i = 0; i < 13; i++){
           if (fila4[i] != null){
                taulerJoc.Posa(fila4[i], 3, i);              
           }
        }
    }
    
         
    private void botonJugar(java.awt.event.ActionEvent e){
        
        Jugador[] jugadors = {jug1, jug2, jug3, jug4};
        repartir(baraja, jugadors);
        
        for(int i = 0; i < 13; i++){
            bv.Posa(jug1.agafarCarta(i), i);
        }
        Carta cartaGirada = new Carta(1, Palo.DIAMONDS, "Cartes/card_back_blue.png");
        bv.setVisible(true);
        taulerM.setVisible(false);
        taulerJoc.setVisible(true);
        for(int i = 0; i < 3; i++){
            ps.Posa(cartaGirada, i);   
        }
        int puntosJug1 = jug2.getContador();
        etiqJug1.setText(Integer.toString(puntosJug1));
        etiqJug1.setBounds(250, 15, 1200/13, 450/4);
        int puntosJug2 = jug3.getContador();
        etiqJug2.setText(Integer.toString(puntosJug2));
        etiqJug2.setBounds(565, 15, 1200/13, 450/4);
        int puntosJug3 = jug4.getContador();
        etiqJug3.setText(Integer.toString(puntosJug3));
        etiqJug3.setBounds(875, 15, 1200/13, 450/4);
        int puntosPropios = jug1.getContador();
        etiqPropia.setText(Integer.toString(puntosPropios));
        pi.textoInf.setText("Les cartes estàn repartides, és el teu torn, posa un 7 si el tens");
        
        pi.botonMesclar.setVisible(false);
        pi.botonJugar.setText("Passa");
        

        while (!haGuanyat) {
            for (int i = 0; (i < 4) && (!haGuanyat); i++) {
                switch (i) {
                    case 0:
                        System.out.println("Jugador 1:");
                        tj.jugar(jug1);
                        mostrarEstadoPartida();
                        puntosPropios = jug1.getContador();
                        etiqPropia.setText(Integer.toString(puntosPropios));
                        if (jug1.getContador() == 0) {
                            haGuanyat = true;
                        }

                        break;
                    case 1:
                        System.out.println("Jugador 2:");
                        tj.jugar(jug2);
                        mostrarEstadoPartida();
                        puntosJug1 = jug2.getContador();
                        etiqJug1.setText(Integer.toString(puntosJug1));
                        if (jug2.getContador() == 0) {
                            haGuanyat = true;
                        }

                        break;
                    case 2:
                        System.out.println("Jugador 3:");
                        tj.jugar(jug3);
                        mostrarEstadoPartida();
                        puntosJug2 = jug3.getContador();
                        etiqJug2.setText(Integer.toString(puntosJug2));
                        if (jug3.getContador() == 0) {
                            haGuanyat = true;
                        }

                        break;
                    case 3:
                        System.out.println("Jugador 4");
                        tj.jugar(jug4);
                        mostrarEstadoPartida();
                        puntosJug3 = jug4.getContador();
                        etiqJug3.setText(Integer.toString(puntosJug3));
                        if (jug4.getContador() == 0) {
                            haGuanyat = true;
                        }

                        break;
                }
            }
        }
        System.out.println("Jugador 1 " + jug1.getContador());
        System.out.println("Jugador 2 " + jug2.getContador());
        System.out.println("Jugador 3 " + jug3.getContador());
        System.out.println("Jugador 4 " + jug4.getContador());

        System.out.println("\n");

        Carta[] jocClubs = tj.getJocClubs();
        for (int i = 0; i < 13; i++) {
            System.out.print(jocClubs[i] + " ");
        }

        System.out.println("\n");

        Carta[] jocDiamonds = tj.getJocDiamonds();
        for (int i = 0; i < 13; i++) {
            System.out.print(jocDiamonds[i] + " ");
        }

        System.out.println("\n");

        Carta[] jocHearts = tj.getJocHearts();
        for (int i = 0; i < 13; i++) {
            System.out.print(jocHearts[i] + " ");
        }

        System.out.println("\n");

        Carta[] jocSpades = tj.getJocSpades();
        for (int i = 0; i < 13; i++) {
            System.out.print(jocSpades[i] + " ");
        }

        System.out.println("\n");

        if (jug1.getContador() == 0) {
            System.out.println("Guanyador Jugador 1");
        } else if (jug2.getContador() == 0) {
            System.out.println("Guanyador Jugador 2");
        } else if (jug3.getContador() == 0) {
            System.out.println("Guanyador Jugador 3");
        } else if (jug4.getContador() == 0) {
            System.out.println("Guanyador Jugador 4");
        }
    }
    
    /*private void ponerFotosMezcladas(){
        Random ran = new Random();
        int aux;
        String s = "";
        for (int j = 1; j < 14; j++){
            aux = ran.nextInt(12);
            s += "Cartes/" + (aux + 1) + "_of_clubs.png";
            taulerM.Posa(s, 0, j - 1);
            s = "";
        }
        
        for (int j = 1; j < 14; j++){
            aux = ran.nextInt(12);
            s += "Cartes/" + (aux+1) + "_of_diamonds.png";
            taulerM.Posa(s, 1, j - 1);
            s = "";
        }
        
        for (int j = 1; j < 14; j++){
            aux = ran.nextInt(12);
            s += "Cartes/" + (aux+1)  + "_of_hearts.png";
            taulerM.Posa(s, 2, j - 1);
            s = "";
        }
        
        for (int j = 1; j < 14; j++){
            aux = ran.nextInt(12);
            s += "Cartes/" + (aux+1) + "_of_spades.png";
            taulerM.Posa(s, 3, j - 1);
            s = "";
        }
                
    }*/
    private static Baralla generarBaralla() {

        Baralla bar = new Baralla();
        Carta c;
        Palo p;

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= 13; j++) {

                switch (i) {
                    case 1:
                        p = Palo.CLUBS;
                        c = new Carta(j, p,"Cartes/" + j + "_of_clubs.png");
                        bar.setBaralla(c);
                        break;

                    case 2:
                        p = Palo.DIAMONDS;
                        c = new Carta(j, p,"Cartes/" + j + "_of_diamonds.png");
                        bar.setBaralla(c);
                        break;

                    case 3:
                        p = Palo.HEARTS;
                        c = new Carta(j, p,"Cartes/" + j + "_of_hearts.png");
                        bar.setBaralla(c);
                        break;

                    case 4:
                        p = Palo.SPADES;
                        c = new Carta(j, p, "Cartes/" + j + "_of_spades.png");
                        bar.setBaralla(c);
                        break;
                }

            }
        }

        return bar;
    }
}
