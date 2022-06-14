/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marcf
 */
public class InterficieGraficaPracticaFinal extends JFrame implements MouseListener, ActionListener {

    private Baralla baraja = generarBaralla();
    private Jugador jug1 = new Jugador();
    private Jugador jug2 = new Jugador();
    private Jugador jug3 = new Jugador();
    private Jugador jug4 = new Jugador();
    private Joc tj = new Joc();
    private Boolean haGuanyat = false;
    private Boolean torn = true;
    private int tornJugs = 0;
    private ImageIcon icono = null;
    //declaración de los diferentes tableros
    private Tablero tauler = new Tablero();
    private Tablero taulerM = new Tablero();
    private Tablero taulerJoc = new Tablero();
    //declaración de los paneles
    private panelInferior pi = new panelInferior();
    private BarallaVisualizer bv = new BarallaVisualizer(13);
    private BarallaVisualizer bv2 = new BarallaVisualizer(1);
    private panelSuperior ps = new panelSuperior();
    //declaración de etiquetas para las puntuaciones
    private JLabel etiqJug1 = new JLabel();
    private JLabel etiqJug2 = new JLabel();
    private JLabel etiqJug3 = new JLabel();
    private JLabel etiqPropia = new JLabel();

    public InterficieGraficaPracticaFinal() {
        this.setSize(1212, 839);
        this.setLayout(null);
        //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(new Color(42, 100, 25));
        this.setTitle("Joc del 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        etiqJug1.setFont(new java.awt.Font("Arial", Font.ITALIC + Font.BOLD, 60));
        this.add(etiqJug1);
        etiqJug1.setBounds(255, 15, 1200 / 13, 450 / 4);

        etiqJug2.setText("0");
        etiqJug2.setForeground(Color.white);
        etiqJug2.setFont(new java.awt.Font("Arial", Font.ITALIC + Font.BOLD, 60));
        this.add(etiqJug2);
        etiqJug2.setBounds(570, 15, 1200 / 13, 450 / 4);

        etiqJug3.setText("0");
        etiqJug3.setForeground(Color.white);
        etiqJug3.setFont(new java.awt.Font("Arial", Font.ITALIC + Font.BOLD, 60));
        this.add(etiqJug3);
        etiqJug3.setBounds(880, 15, 1200 / 13, 450 / 4);

        //afegim el panell superior amb les caselles
        this.add(ps);
        ps.setBounds(0, -100, 1200, 300);

        //afegim el panell de botons inferior
        this.add(pi);
        pi.setBounds(0, 750, 1200, 50);

        //posam les fotos de la baralla ordenada i afegim el tauler inicial
        ponerFotosOrden();
        this.add(tauler);
        tauler.setBounds(0, 140, 1200, 500);

        //afegim el tauler amb les cartes mesclades (no visible inicialment)
        this.add(taulerM);
        taulerM.setBounds(0, 140, 1200, 500);
        taulerM.setVisible(false);

        //afegim el tauler buid on jugar (no visible inicialment)
        this.add(taulerJoc);
        taulerJoc.setBounds(0, 140, 1200, 500);
        taulerJoc.setVisible(false);

        //configuració de la etiqueta inferior
        etiqPropia.setText("0");
        etiqPropia.setForeground(Color.white);
        etiqPropia.setFont(new java.awt.Font("Arial", Font.ITALIC + Font.BOLD, 40));
        this.add(etiqPropia);

        etiqPropia.setBounds(42, 590, 50, 50);
        //afegim el visualizer de la baralla inferior (no visible inicialment)
        this.add(bv);

        bv.setBounds(0, 520, 1200, 400);
        bv.setVisible(false);

        //afegim el visualizer de dimensió 1
        this.add(bv2);

        bv2.setBounds(3, 520, 1200, 400);

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

        pi.botonPasar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonPasar(evt);
            }
        });

        pi.botonTornJug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonTornJug(evt);
            }
        });

        bv.addMouseListener(this);

    }

    private void ponerFotosOrden() {
        for (int j = 0; j < 13; j++) {
            tauler.Posa(baraja.getCarta(j), 0, j);
        }

        for (int j = 0; j < 13; j++) {
            tauler.Posa(baraja.getCarta(j + 13), 1, j);
        }

        for (int j = 0; j < 13; j++) {
            tauler.Posa(baraja.getCarta(j + 26), 2, j);
        }

        for (int j = 0; j < 13; j++) {
            tauler.Posa(baraja.getCarta(j + 39), 3, j);
        }

    }

    private void botonMesclar(java.awt.event.ActionEvent e) {
        tauler.setVisible(false);
        baraja.mesclar();
        ponerFotosMezcladas();
        taulerM.setVisible(true);
        pi.botonJugar.setEnabled(true);
        pi.botonJugar.setBackground(Color.BLUE);
        pi.botonReiniciar.setEnabled(true);
        pi.textoInf.setText("La baralla està mesclada");
    }

    private void botonReiniciar(java.awt.event.ActionEvent e) {
        taulerM.setVisible(false);
        tauler.setVisible(true);
        pi.botonJugar.setEnabled(false);
        pi.botonReiniciar.setEnabled(false);
        pi.textoInf.setText("Abans de jugar cal barallar!");
        bv.setVisible(false);
        taulerJoc.setVisible(false);
        pi.botonMesclar.setVisible(true);
        pi.botonJugar.setText("Jugar");

        //reiniciar munts de jugadors
        jug1 = new Jugador();
        jug2 = new Jugador();
        jug3 = new Jugador();
        jug4 = new Jugador();

        //reinicair punts
        int puntosJug1 = jug2.getContador();
        etiqJug1.setText(Integer.toString(puntosJug1));
        etiqJug1.setBounds(250, 15, 1200 / 13, 450 / 4);
        int puntosJug2 = jug3.getContador();
        etiqJug2.setText(Integer.toString(puntosJug2));
        etiqJug2.setBounds(565, 15, 1200 / 13, 450 / 4);
        int puntosJug3 = jug4.getContador();
        etiqJug3.setText(Integer.toString(puntosJug3));
        etiqJug3.setBounds(875, 15, 1200 / 13, 450 / 4);
        int puntosPropios = jug1.getContador();
        etiqPropia.setText(Integer.toString(puntosPropios));

        haGuanyat = false;
        tj = new Joc();

        taulerJoc = new Tablero();
        taulerJoc.setBounds(0, 140, 1200, 500);
        taulerJoc.setVisible(false);

    }

    private void botonPasar(java.awt.event.ActionEvent e) {
        torn = false;
        pi.botonPasar.setVisible(false);
        pi.botonTornJug.setVisible(true);
        comprovarJoc();
    }

    private void comprovarJoc() {
        int puntosPropios = jug1.getContador();
        etiqPropia.setText(Integer.toString(puntosPropios));
        if (jug1.getContador() == 0) {
            haGuanyat = true;
            icono = new ImageIcon("Cartes/Jug0Riu.png");
            JOptionPane.showMessageDialog(null, "HAS GUANYAT! ", "Final de partida", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

    private void botonTornJug(java.awt.event.ActionEvent e) {
        
        int puntosJug1 = jug2.getContador();
        etiqJug1.setText(Integer.toString(puntosJug1));
        etiqJug1.setBounds(250, 15, 1200 / 13, 450 / 4);
        int puntosJug2 = jug3.getContador();
        etiqJug2.setText(Integer.toString(puntosJug2));
        etiqJug2.setBounds(565, 15, 1200 / 13, 450 / 4);
        int puntosJug3 = jug4.getContador();
        etiqJug3.setText(Integer.toString(puntosJug3));
        etiqJug3.setBounds(875, 15, 1200 / 13, 450 / 4);

        switch (tornJugs) {
            case 0:
                pi.textoInf.setText("Torn del Jugador 1");
                tj.jugar(jug2);
                mostrarEstadoPartida();
                puntosJug1 = jug2.getContador();
                etiqJug1.setText(Integer.toString(puntosJug1));
                if (jug2.getContador() == 0) {
                    haGuanyat = true;
                    icono = new ImageIcon("Cartes/Jug1Riu.png");
                    JOptionPane.showMessageDialog(null, "HA GUANYAT EL JUGADOR 1!", "Final de partida", JOptionPane.INFORMATION_MESSAGE, icono);
                }
                tornJugs++;

                break;
            case 1:
                pi.textoInf.setText("Torn del Jugador 2");
                tj.jugar(jug3);
                mostrarEstadoPartida();
                puntosJug2 = jug3.getContador();
                etiqJug2.setText(Integer.toString(puntosJug2));
                if (jug3.getContador() == 0) {
                    haGuanyat = true;
                    icono = new ImageIcon("Cartes/Jug2Riu.png");
                    JOptionPane.showMessageDialog(null, "HA GUANYAT EL JUGADOR 2!", "Final de partida", JOptionPane.INFORMATION_MESSAGE, icono);
                }
                tornJugs++;

                break;
            case 2:
                pi.textoInf.setText("Torn del Jugador 3");
                tj.jugar(jug4);
                mostrarEstadoPartida();
                puntosJug3 = jug4.getContador();
                etiqJug3.setText(Integer.toString(puntosJug3));
                if (jug4.getContador() == 0) {
                    haGuanyat = true;
                    icono = new ImageIcon("Cartes/Jug3Riu.png");
                    JOptionPane.showMessageDialog(null, "HA GUANYAT EL JUGADOR 3! ", "Final de partida", JOptionPane.INFORMATION_MESSAGE, icono);
                }
                tornJugs = 0;
                torn = true;
                pi.botonTornJug.setVisible(false);
                pi.botonPasar.setVisible(true);

                break;
        }

//        pi.botonTornJug.setVisible(false);
//        pi.botonPasar.setVisible(true);
    }

    private void ponerFotosMezcladas() {
        for (int j = 0; j < 13; j++) {
            taulerM.Posa(baraja.getCarta(j), 0, j);
        }

        for (int j = 0; j < 13; j++) {
            taulerM.Posa(baraja.getCarta(j + 13), 1, j);
        }

        for (int j = 0; j < 13; j++) {
            taulerM.Posa(baraja.getCarta(j + 26), 2, j);
        }

        for (int j = 0; j < 13; j++) {
            taulerM.Posa(baraja.getCarta(j + 39), 3, j);
        }

        this.repaint();
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

    private void mostrarEstadoPartida() {
        Carta[] fila1 = tj.getJocClubs();
        Carta[] fila2 = tj.getJocDiamonds();
        Carta[] fila3 = tj.getJocHearts();
        Carta[] fila4 = tj.getJocSpades();

        for (int i = 0; i < 13; i++) {
            if (fila1[i] != null) {
                taulerJoc.Posa(fila1[i], 0, i);
            }

        }
        for (int i = 0; i < 13; i++) {
            if (fila2[i] != null) {
                taulerJoc.Posa(fila2[i], 1, i);
            }
        }
        for (int i = 0; i < 13; i++) {
            if (fila3[i] != null) {
                taulerJoc.Posa(fila3[i], 2, i);
            }
        }
        for (int i = 0; i < 13; i++) {
            if (fila4[i] != null) {
                taulerJoc.Posa(fila4[i], 3, i);
            }
        }
        this.repaint();
    }

    private void botonJugar(java.awt.event.ActionEvent e) {

        ImageIcon icono = null;
        Jugador[] jugadors = {jug1, jug2, jug3, jug4};

        repartir(baraja, jugadors);

        for (int i = 0; i < 13; i++) {
            bv.Posa(jug1.agafarCarta(i), i);
        }

        Carta cartaGirada = new Carta(1, Palo.DIAMONDS, "Cartes/card_back_blue.png");
        bv.setVisible(true);
        taulerM.setVisible(false);
        taulerJoc.setVisible(true);
        for (int i = 0; i < 3; i++) {
            ps.Posa(cartaGirada, i);
        }
        int puntosJug1 = jug2.getContador();
        etiqJug1.setText(Integer.toString(puntosJug1));
        etiqJug1.setBounds(250, 15, 1200 / 13, 450 / 4);
        int puntosJug2 = jug3.getContador();
        etiqJug2.setText(Integer.toString(puntosJug2));
        etiqJug2.setBounds(565, 15, 1200 / 13, 450 / 4);
        int puntosJug3 = jug4.getContador();
        etiqJug3.setText(Integer.toString(puntosJug3));
        etiqJug3.setBounds(875, 15, 1200 / 13, 450 / 4);
        int puntosPropios = jug1.getContador();
        etiqPropia.setText(Integer.toString(puntosPropios));
        pi.textoInf.setText("Les cartes estàn repartides, és el teu torn, posa un 7 si el tens");

        pi.botonMesclar.setVisible(false);
        pi.botonJugar.setVisible(false);
        pi.botonPasar.setVisible(true);

    }

    private static Baralla generarBaralla() {

        Baralla bar = new Baralla();
        Carta c;
        Palo p;

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= 13; j++) {

                switch (i) {
                    case 1:
                        p = Palo.CLUBS;
                        c = new Carta(j, p, "Cartes/" + j + "_of_clubs.png");
                        bar.setBaralla(c);
                        break;

                    case 2:
                        p = Palo.DIAMONDS;
                        c = new Carta(j, p, "Cartes/" + j + "_of_diamonds.png");
                        bar.setBaralla(c);
                        break;

                    case 3:
                        p = Palo.HEARTS;
                        c = new Carta(j, p, "Cartes/" + j + "_of_hearts.png");
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            int posicio = retornarPos(e);
            if (torn) {
                Casella cas = bv.getCasella(posicio);
                Carta c = cas.getCarta();
                System.out.println(c);
                tj.colocarCarta(c, jug1);
                mostrarEstadoPartida();

                //comprovar si la carta ha estat colocada
                if (tj.getColocada()) {
                    comprovarJoc();
                    bv.modCasella(posicio);
                    pi.botonPasar.setVisible(false);
                    pi.botonTornJug.setVisible(true);
                    torn = false;
                    tj.resetColocada();
                }
            }

        }catch(NullPointerException ex){
            System.out.println("Carta ja possada");
        }

    }

    private int retornarPos(MouseEvent e) {
        int x = 0, y = 0, i = 0;
        int aux1, aux2;
        x = e.getX();
        y = e.getY();
        boolean flag = false;
        for (i = 0; i < 13 && !flag; i++) {
            flag = bv.comprovarclick(i, x, y);
        }
        i--;
        return i;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
