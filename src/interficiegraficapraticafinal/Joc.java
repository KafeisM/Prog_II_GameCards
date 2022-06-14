/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interficiegraficapraticafinal;

/**
 *
 * @author Usuario
 */
public class Joc {

    //arrays de les cartes del joc (una per palo)
    private static Carta[] jocClubs;
    private static boolean[] ocupadaClubs;

    private static Carta[] jocDiamonds;
    private static boolean[] ocupadaDiamonds;

    private static Carta[] jocSpades;
    private static boolean[] ocupadaSpades;

    private static Carta[] jocHearts;
    private static boolean[] ocupadaHearts;

    private static Boolean colocada = false;

    public Joc() {
        jocClubs = new Carta[13];
        ocupadaClubs = new boolean[13];

        jocDiamonds = new Carta[13];
        ocupadaDiamonds = new boolean[13];

        jocSpades = new Carta[13];
        ocupadaSpades = new boolean[13];

        jocHearts = new Carta[13];
        ocupadaHearts = new boolean[13];
    }

    //comprovar tota la baralla 
    public void jugar(Jugador munt) {
        Carta c = null;
        Palo pal = null;
        int valor;

        for (int i = 0; i < 13 && !colocada; i++) {
            c = munt.agafarCarta(i);
            valor = c.getValor();
            pal = c.getPalo();

            selecionarPalo(pal, valor, munt, c);
        }

        if (!colocada) {
            System.out.println("no se ha colocat cap carta");
        }
        if(c == null){
            System.out.println("error");
        }

        colocada = false;
    }

    //comprovar nomes una carta pasada per parametre
    public void colocarCarta(Carta c, Jugador munt) {
        Palo pal = c.getPalo();
        int valor = c.getValor();

        selecionarPalo(pal, valor, munt, c);

    }

    private void selecionarPalo(Palo pal, int valor, Jugador munt, Carta c) {
        if (null != pal) {
            switch (pal) {
                case CLUBS:
                    ComprovarCarta(jocClubs, ocupadaClubs, valor, munt, c);
                    break;
                case DIAMONDS:
                    ComprovarCarta(jocDiamonds, ocupadaDiamonds, valor, munt, c);
                    break;
                case HEARTS:

                    ComprovarCarta(jocHearts, ocupadaHearts, valor, munt, c);
                    break;
                case SPADES:
                    ComprovarCarta(jocSpades, ocupadaSpades, valor, munt, c);
                    break;
                default:
                    break;
            }
        }
    }

    public void ComprovarCarta(Carta[] Joc, boolean[] Ocupada, int valor, Jugador munt, Carta c) {

        if (valor == 7 && Ocupada[6] == false) {
            Joc[6] = c;
            Ocupada[6] = true;
            munt.modCont();
            colocada = true;
            System.out.println("Se ha colocat " + c);
            return;
        } else {
            //si entra al else
            for (int j = 0; j < Joc.length; j++) {
                if ((j != 0) && (j != 12)) {
                    //si la posicio anterior esta lliure
                    if ((Ocupada[j] == true) && (Ocupada[j - 1] == false)) {
                        if (valor == j) {
                            Joc[j - 1] = c;
                            Ocupada[j - 1] = true;
                            munt.modCont();
                            colocada = true;
                            System.out.println("Se ha colocat " + c);
                            return;
                        }
                    } 
                    //si la posicio posterior esta lliure
                    if ((Ocupada[j] == true) && (Ocupada[j + 1] == false)) {
                        //no entra a este if 
                        if (valor == j + 2) {

                            Joc[j + 1] = c;
                            Ocupada[j + 1] = true;
                            munt.modCont();
                            colocada = true;
                            System.out.println("Se ha colocat " + c);
                            return;
                        }
                    }

                }
            }
        }

    }

    public static Boolean getColocada() {
        return colocada;
    }

    public static Carta[] getJocClubs() {
        return jocClubs;
    }

    public static Carta[] getJocDiamonds() {
        return jocDiamonds;
    }

    public static Carta[] getJocSpades() {
        return jocSpades;
    }

    public static Carta[] getJocHearts() {
        return jocHearts;
    }
    
    public static void resetColocada(){
        colocada = false;
    }

}
