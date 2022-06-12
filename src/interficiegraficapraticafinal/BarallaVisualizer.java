/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author marcf
 */
public class BarallaVisualizer extends JPanel{
    
    private Casella[] visu;
    private int dim;
    private static final int BASE = 1200/13;
    private static final int ALTURA = 450/4;
    
    public BarallaVisualizer(int i){
        this.dim = i;
        visu = new Casella[dim];
        Color col = new Color(32,79,18);
            for (int j = 0; j < dim; j++){
                Rectangle2D.Float ra = new Rectangle2D.Float(j*BASE, ALTURA, BASE, ALTURA);
                visu[j] = new Casella(ra, col);            
            }
    }
    
    public boolean comprovarclick(int i, int x, int y) {
        return visu[i].getRec().contains(x, y);
    }
    
    public Casella getCasella(int i) {
        return visu[i];
    }
    
        @Override
    public void paintComponent(Graphics g){
        for (int j = 0; j < dim; j++){ 
            visu[j].paintComponent(g);
        }                      
    }  
    
    public void Posa(Carta c, int i0){
        visu[i0].setCarta(c);
    }
    
}
