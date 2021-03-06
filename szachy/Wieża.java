package szachy;

/**
 * Created by RAFAŁ on 2017-01-27 17:42.
 */
public class Wieża extends Bierka {

    public Wieża(Kolor kolor) {
        super(kolor);
        wektoryPrzemieszczenia = new int[][]{
                {0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {0,6}, {0,7},
                {0,-1}, {0,-2}, {0,-3}, {0,-4}, {0,-5}, {0,-6}, {0,-7},
                {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0},
                {-1,0}, {-2,0}, {-3,0}, {-4,0}, {-5,0}, {-6,0}, {-7,0}
        };
    }

    @Override
    protected boolean czyWidzęPole(Pole pole) {
        // metodę tą można stosować jedynie wobec pól,
        // na których bierka mogłaby stanąć, gdyby jej nikt nie zasłaniał
        // tak właśnie jest w tym programie
        //
        // w tej metodzie sprawdzamy czy wszystkie pola łączące nasze pole z polem docelowym są wolne
        //
        int x1 = this.pole.dajX();
        int y1 = this.pole.dajY();
        int x2 = pole.dajX();
        int y2 = pole.dajY();
        boolean czyWidzę = true;
        int[] kierunek = new int[2];
        // ustalenie wektora jednostkowego pokazującego w kierunku ruchu
        if (x2 - x1 == 0 && y2 - y1 > 0){
            kierunek = new int[]{0,1};
        }
        if (x2 - x1 == 0 && y2 - y1 < 0){
            kierunek = new int[]{0,-1};
        }
        if (x2 - x1 > 0 && y2 - y1 == 0){
            kierunek = new int[]{1,0};
        }
        if (x2 - x1 < 0 && y2 - y1 == 0){
            kierunek = new int[]{-1,0};
        }
        //  sprawdzamy czy wszystkie pola łączące nasze pole z polem docelowym są wolne
        int x = x1 + kierunek[0];
        int y = y1 + kierunek[1];
        while(!(x == x2 && y == y2)){
            if (!this.pole.szachownica.pola[x][y].czyWolne()){
                czyWidzę = false;
                break;
            }
            x += kierunek[0];
            y += kierunek[1];
        }

        return czyWidzę;
    }

    @Override
    public String toString() {
        return (this.kolor == Kolor.biały) ? "\u2656" : "\u265C";
    }
}
