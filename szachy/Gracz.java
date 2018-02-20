package szachy;

import java.util.ArrayList;

/**
 * Created by RAFAŁ on 2017-01-27 15:13.
 */
public abstract class Gracz {

    protected Kolor kolor; // atrybut kolor jest inicjalizowany przez Rozgrywkę
    protected final String imię;

    public Gracz(String imię) {
        this.imię = imię;
    }

    @Override
    public String toString() {
        String kolorGracza = null; // chodzi o to, że o graczu mówimy "białe" raczej niż "biały"
        if (kolor == Kolor.biały){
            kolorGracza = "białe";
        }
        if (kolor == Kolor.czarny){
            kolorGracza = "czarne";
        }
        return imię + " (" + kolorGracza + ")";
    }

    protected abstract Ruch wybierzRuch(ArrayList<Ruch> listaRuchów);
}
