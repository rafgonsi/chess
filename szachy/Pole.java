package szachy;

/**
 * Created by RAFAŁ on 2017-01-22 15:44.
 */
public class Pole {

    protected Bierka bierka;
    protected Szachownica szachownica;
    protected final int x, y;

    public Pole(int x, int y, Szachownica szachownica) {
        this.x = x;
        this.y = y;
        this.szachownica = szachownica; // Pole wie, na jakiej szachownicy się znajduje. To potrzebne do określania ruchu na inne Pole
    }

    protected int dajX() {
        return x;
    }
    protected int dajY() {
        return y;
    }
    protected String nazwaPola(){
        return "ABCDEFGH".charAt(this.y) + String.valueOf(this.x + 1);
    }

    protected boolean czyWolne(){ // mówi czy pole jest wolne
        if (this.bierka == null){
            return true;
        } else {
            return false;
        }
    }

    protected Bierka jakaBierka(){ // jeśli pole jest puste zwraca null
        return bierka;
    }

    protected void dodajBierkę(Bierka bierka){
        assert czyWolne() : "Klasa Pole. Metoda dodajBierkę(). Chcesz umieścić drugą Bierkę na tym samym Polu."; // to się nigdy nie stanie
        this.bierka = bierka;
        this.bierka.ustawPole(this); // sprawia, że Bierka wie, na jakim polu stoi

    }

    protected void usuńBierkę(){
        this.bierka.zdejmij(); // to powoduje, że atrybut Bierki - Pole - też staje się nullem
        this.bierka = null;
    }

    @Override
    public String toString() {
        return ((this.bierka != null) ? this.bierka.toString() : ".");
    }
}








