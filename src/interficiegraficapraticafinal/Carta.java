/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jordi
 */
public class Carta {
    //una carta esta composada per un palo i un valor
    private Palo palo; 
    private int valor;
    private String source;
    private BufferedImage img;

    public Carta(int v, Palo p, String foto) {
        palo = p;
        valor = v;
        source = foto;
        try{
            img = ImageIO.read(new File(source));
        } catch (IOException e){          
        }
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public String getSource() {
        return source;
    }
    
    @Override
    public String toString() {
        return "Carta{" + "palo=" + palo + ", valor=" + valor + '}';
    }

    void paintComponent(Graphics g, float x, float y){
        g.drawImage(img, (int) x + 3, (int) y + 3, (1200/13)-3, (450/4) - 3, null);
    }    
}
