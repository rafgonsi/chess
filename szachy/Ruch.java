package szachy;

/**
 * Created by RAFAŁ on 2017-01-22 16:37.
 */
public class Ruch {

    protected Pole skąd;
    protected Pole dokąd;
    protected Bierka kto;
    protected Bierka kogoBije;

    public Ruch(Pole skąd, Pole dokąd) {
        this.skąd = skąd;
        this.dokąd = dokąd;
        this.kto = skąd.jakaBierka();
        this.kogoBije = dokąd.jakaBierka(); // założenie: nie będziemy tworzyli niemożliwych ruchów
                                        // i na tym polu zawsze będzie albo pusto albo bierka przeciwnego koloru
                                        // Użytkownik nie ma dostępu do powstawania ruchu, więc niczego nie zepsuje.
    }

    protected boolean czyBije(){
        return (kogoBije != null);
    }

    // Program jest tak napisany, że jeśli pojawia się w nim obiekt klasy Ruch, to możliwe jest wykonanie tego ruchu.
    // Ruchy, których nie da się wykonać w ogóle nie są tworzone.
    protected void wykonajSię(){
        skąd.usuńBierkę(); // zwalnia pole, na którym jest bierka i ustawia artybut Bierki - pole - na null
        if (dokąd.czyWolne()){
            dokąd.dodajBierkę(kto); // wstawia poruszającą się bierkę na pole docelowe
        } else if (dokąd.jakaBierka().jakiKolor() != kto.jakiKolor()){
            // To jest ruch z biciem
            dokąd.usuńBierkę();
            dokąd.dodajBierkę(kto);
        }
    }

    protected boolean czyWygrywa(){ // jeśli bijemy któla to jest ruch wygrywający
        return (kogoBije instanceof Król);
    }

    @Override
    public String toString() {
        return kto.toString() + skąd.nazwaPola().toString() + (czyBije() ? ":" : " ") + dokąd.nazwaPola();
    }
}
