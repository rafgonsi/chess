package szachy;

/**
 * Created by RAFAŁ on 2017-01-22 22:56.
 */
public class Król extends Bierka {

    public Król(Kolor kolor) {
        super(kolor);
        wektoryPrzemieszczenia = new int[][]{
                {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}
        };
    }

    @Override
    protected boolean czyWidzęPole(Pole pole) {
        // metodę tą można stosować jedynie wobec pól,
        // na których bierka mogłaby stanąć, gdyby jej nikt nie zasłaniał.
        // król porusza się po jednym polu, więc zawsze je widzi - nikt mu nie zasłania.
        return true;
    }

     @Override
    public String toString() {
        return (this.kolor == Kolor.biały) ? "\u2654" : "\u265A";
    }

}
