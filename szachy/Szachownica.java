package szachy;

/**
 * Created by RAFAŁ on 2017-01-22 15:44.
 */
public class Szachownica {
    protected Pole[][] pola;

//     Zastosowałem naturalną dla macierzy konwencję numerowania
//     jej elementów - macierz[numer wiersza][numer kolumny],
//     która jest nienaturalna w szachach - mówiąc o polu podajemy najpierw
//     numer kolumny, a dopiero potem numer wiersza np. D4

    public Szachownica(){
        // szachownica składa się z 64 pól, które tworzymy poniżej
        this.pola = new Pole[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                this.pola[i][j] = new Pole(i, j,this);
            }
        }
        rozstawBierki(); // ustawia bierki na szachownicy
    }

    private void rozstawBierki() {
        this.pola[0][0].dodajBierkę(new Wieża(Kolor.biały));
        this.pola[0][7].dodajBierkę(new Wieża(Kolor.biały));
        this.pola[0][1].dodajBierkę(new Skoczek(Kolor.biały));
        this.pola[0][6].dodajBierkę(new Skoczek(Kolor.biały));
        this.pola[0][2].dodajBierkę(new Goniec(Kolor.biały));
        this.pola[0][5].dodajBierkę(new Goniec(Kolor.biały));
        this.pola[0][4].dodajBierkę(new Król(Kolor.biały));
        this.pola[0][3].dodajBierkę(new Hetman(Kolor.biały));
        this.pola[7][0].dodajBierkę(new Wieża(Kolor.czarny));
        this.pola[7][7].dodajBierkę(new Wieża(Kolor.czarny));
        this.pola[7][1].dodajBierkę(new Skoczek(Kolor.czarny));
        this.pola[7][6].dodajBierkę(new Skoczek(Kolor.czarny));
        this.pola[7][2].dodajBierkę(new Goniec(Kolor.czarny));
        this.pola[7][5].dodajBierkę(new Goniec(Kolor.czarny));
        this.pola[7][4].dodajBierkę(new Król(Kolor.czarny));
        this.pola[7][3].dodajBierkę(new Hetman(Kolor.czarny));
        for (int i = 0; i < 8; i++){
            this.pola[1][i].dodajBierkę(new Pion(Kolor.biały));
            this.pola[6][i].dodajBierkę(new Pion(Kolor.czarny));
        }
    }

    @Override
    public String toString() {
        String kolumny = "ABCDEFGH";
        String wynik = "\n";
        for (int i = 7; i >= 0; i--){
            wynik += String.valueOf(i + 1) + ": ";
            for (int j = 0; j < 8; j++){
                wynik += pola[i][j].toString() + " ";
            }
            wynik += "\n";
        }
        wynik += "   ";
        for (int i = 0; i < 8; i++){
            wynik += kolumny.charAt(i) + " ";
        }
        wynik += "\n";
        return wynik;
    }
}
