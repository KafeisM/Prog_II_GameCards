package interficiegraficapraticafinal;

public class Jugador {

    //Un jugador consta de 13 cartes i un contador de cartes
    private Carta[] munt;
    private int ind;
    private int cnt;

    public Jugador() {
        munt = new Carta[13]; //Munt de 13 cartes de un jugador.
        ind = 0;
        cnt = 0;
    }

    public void setMunt(Carta c) {
        munt[ind++] = c;

        cnt++;
    }

    public Carta agafarCarta(int i) {
        return munt[i];
    }

    public int getContador() {
        return cnt;
    }
    
    public void modCont(){
        --cnt;
    }

//    @Override
//    public String toString() {
//        Carta c;
//        String output = "";
//
//        for (int i = 0; i < ind; i++) {
//            c = munt[i];
//            output += c.toString() + "\n";
//        }
//
//        return output;
//
//    }
}
