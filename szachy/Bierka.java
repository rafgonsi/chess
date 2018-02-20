package szachy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by RAFAŁ on 2017-01-22 16:50.
 */
public abstract class Bierka {

    protected Pole pole;
    protected Kolor kolor;
    protected int[][] wektoryPrzemieszczenia;

    public Bierka(Kolor kolor) {
        this.pole = null;
        this.kolor = kolor;
    }

    protected void ustawPole(Pole pole){ //uwaga. Ta metoda zmienia tylko swój atrybut, a nie stan szachownicy!
//        System.out.println("Klasa Bierka. Metoda ustaw(Pole). " + pole + " wchodzi na " + pole.nazwaPola()); // debug
        this.pole = pole;
    }

    protected void zdejmij(){ //uwaga. Ta metoda zmienia tylko swój atrybut, a nie stan szachownicy!
//        System.out.println("Klasa Bierka. Metoda zdejmij(). " + pole + " schodzi z " + pole.nazwaPola()); //debug
        this.pole = null;
    }

    protected Kolor jakiKolor(){
        return this.kolor;
    }

    protected abstract boolean czyWidzęPole(Pole pole);

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
            // czy nic nie zasłania tego pola:
            if(!czyWidzęPole(poleNowe)){
                continue;
            }
            // zależnie od tego, czy pole jest wolne czy zajęte, reakcje są różne:
            if(poleNowe.czyWolne()){
                // jeśli pole wolne to idziemy na nie
                wynik.add(new Ruch(pole, poleNowe));
            } else if (this.kolor != poleNowe.jakaBierka().jakiKolor()){
                // jeśli pole zajęte przez bierkę innego koloru to bijemy
                wynik.add(new Ruch(pole, poleNowe));
            }
        }

        return wynik;
    };

    @Override
    public abstract String toString();

}
