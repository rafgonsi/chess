package szachy;

import java.util.ArrayList;

/**
 * Created by RAFAŁ on 2017-01-28 11:43.
 */
public class Pion extends Bierka {

    public Pion(Kolor kolor) {
        super(kolor);
        if (kolor == Kolor.biały){
            wektoryPrzemieszczenia = new int[][]{
                    {1,-1}, {1,0}, {1,1}
            };
        } else {
            wektoryPrzemieszczenia = new int[][]{
                    {-1, -1}, {-1, 0}, {-1, 1}
            };
        }
    }

    @Override
    protected ArrayList<Ruch> podajMożliweRuchy(){
        // tworzy listę Ruchów, które Bierka może wykonać
        ArrayList<Ruch> wynik = new ArrayList<>();
        // sprawdza, czy pole docelowe ruchu mieści się na szachownicy:
        for (int i = 0; i < wektoryPrzemieszczenia.length; i++){
            int x = pole.dajX() + wektoryPrzemieszczenia[i][0];
            int y = pole.dajY() + wektoryPrzemieszczenia[i][1];
            if (x < 0 || x > 7){
                continue;
            }
            if (y < 0 || y > 7){
                continue;
            }
            Pole poleNowe = pole.szachownica.pola[x][y]; // pole, na którym stanie bierka
                                                        // jest innym polem na tej samej szachownicy
            if(!czyWidzęPole(poleNowe)){
                // w tej chwili nie jest to potrzebne. Jeśli natomiast chcielibyśmy
                // dodać możliwość wykonania pierwszego ruchu piona o dwa pola,
                // wtedy potrzebowalibyśmy tego sprawdzenia, czy taki ruch nie jest blokowany
                // przez inną figurę. Oczywiście należałoby wtedy też zmienić metodę czyWidzęPole.
                continue;
            }
            // Ruchy piona zależą od zajętości pól, na które chciałby się przemieścić:
            if(poleNowe.czyWolne()){
                if(wektoryPrzemieszczenia[i][1] == 0){
                    // ruch piona na wprost
                    wynik.add(new Ruch(pole, poleNowe));
                }
            } else if (this.kolor != poleNowe.jakaBierka().jakiKolor() && wektoryPrzemieszczenia[i][1] != 0){
                // jeśli to pole jest zajęte przez bierkę innego koloru i jest na skos to bijemy
                wynik.add(new Ruch(pole, poleNowe));
            }
        }

        return wynik;
    }

    @Override
    protected boolean czyWidzęPole(Pole pole) {
        // pion porusza się po jednym polu, więc zawsze je widzi. Ta metoda byłaby natomiast konieczna,
        // pozwolić pionowi poruszać się po dwa pola w pierwszym jego ruchu.
        return true;
    }

    @Override
    public String toString() {
        return (this.kolor == Kolor.biały) ? "\u2659" : "\u265F";
    }

}
