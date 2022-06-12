/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marcf
 */
public class panelSuperior extends JPanel{
    
    private Casella[] visu;

    private static final int BASE = 1200/13;
    private static final int ALTURA = 450/4;
    
    public panelSuperior(){

        visu = new Casella[3];
        Color col = new Color(32,79,18);
            for (int j = 0; j < 3; j++){
                Rectangle2D.Float ra = new Rectangle2D.Float(j*BASE + 220 + (j*220), ALTURA, BASE, ALTURA);
                visu[j] = new Casella(ra, col);            
            }
    }
    
    
        @Override
    public void paintComponent(Graphics g){
        for (int j = 0; j < 3; j++){ 
            visu[j].paintComponent(g);
        }                      
    }  
    
    public void Posa(Carta c, int i0){
        visu[i0].setCarta(c);
    }
    
}
