/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

import java.util.Random;

/**
 *
 * @author jordi
 */
public class Baralla {
    
    //La baralla es una array de cartes amb les cuals podem acceedir amb un index
    private Carta[] baralla;
    private int total = 52;
    private int ind;

    public Baralla() {
        baralla = new Carta[total];
        ind = 0;
    }
    
    //Mètode setter per afegir cartes a la baralla
    public void setBaralla(Carta c) {
        baralla[ind++] = c;
    }
    //Mètode getter per treure una carta de la baralla
    public Carta getCarta(int i){
        return baralla[i];
    }
    
    public int getTotal(){
        return total;
    }

    public void mesclar() {
        Random r = new Random();
        int azr;
        Carta temp;

        //Començam desde el darrer element i cambiam un a un
        for (int i = baralla.length - 1; i >= 0; i--) {

            // Elegim un numero aleatori entre 0 i l'index
            azr = r.nextInt(i + 1);

            //cambiam l'element actual per el que ha sortir al random
            temp = baralla[i];
            baralla[i] = baralla[azr];
            baralla[azr] = temp;
        }
    }
    
    public Carta repartir(int i){
        return baralla[i];
    }

    @Override
    public String toString() {
        Carta c;
        String output = "";

        for (int i = 0; i < ind; i++) {
            c = baralla[i];
            output += c.toString() + "\n";
        }

        return output;

    }

}
