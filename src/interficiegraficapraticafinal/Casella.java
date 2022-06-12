/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author marcf
 */
public class Casella {
    
    private Rectangle2D.Float rec;
    private Color color;
    private boolean ocupada;
    private Carta carta;
    
    
    private final Color colorF = new Color(42, 100, 25);
    
    
    public Casella(Rectangle2D.Float r, Color c){
        this.rec = r;
        this.color = c;
        this.ocupada = false;
        this.carta = null;
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fill(this.rec);
        if (this.ocupada){
            this.carta.paintComponent(g, this.rec.x, this.rec.y);
        }
        
        g2d.setColor(colorF);
        g2d.setStroke(new BasicStroke(4));
        g2d.draw(rec);
    }
    
    public void setCarta(Carta c){
        this.ocupada = true;
        this.carta = c;
    }
    
    public Carta getCarta(){
        return carta;
    }
    public Rectangle2D.Float getRec() {
        return rec;
    }
    
}
