/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Tauler extends JPanel{
    
    private static final int BASE = 1200/13;
    private static final int ALTURA = 450/4;
    private Casella tauler[][];
    
    public Tauler(){
        this.setSize(1200, 450);
        tauler = new Casella[4][13];
        Color col = new Color(32,79,18);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                Rectangle2D.Float ra = new Rectangle2D.Float(j*BASE, i*ALTURA, BASE, ALTURA);
                tauler[i][j] = new Casella(ra, col);
            }
        }
    }
    
    //esborra la casella
    public void reiniciarTauler(int i ,int j) {
        Color col = new Color(32,79,18);
        Rectangle2D.Float ra = new Rectangle2D.Float(j*BASE, i*ALTURA, BASE, ALTURA);
        Casella aux = new Casella(ra, col);
        tauler[i][j] = aux;
    }
    
    @Override
    public void paintComponent(Graphics g){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){ 
                tauler[i][j].paintComponent(g);
            }
        }               
    }  
    
    public void Posa(Carta c, int i, int i0){
        tauler[i][i0].setCarta(c);
    }
    
    
}
