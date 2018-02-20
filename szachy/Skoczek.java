package szachy;

/**
 * Created by RAFAŁ on 2017-01-27 17:32.
 */
public class Skoczek extends Bierka {

    public Skoczek(Kolor kolor) {
        super(kolor);
        wektoryPrzemieszczenia = new int[][]{
                {2,-1}, {2,1}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {-1,-2}, {-1,2}
        };
    }

    @Override
    protected boolean czyWidzęPole(Pole pole) {
        // metodę tą można stosować jedynie wobec pól,
        // na których bierka mogłaby stanąć, gdyby jej nikt nie zasłaniał.
        // skoczek przeskakuje nad innymi bierkami, więc zawsze widzi pole,
        // na którym chce stanąć.
        return true;
    }

    @Override
    public String toString() {
        return (this.kolor == Kolor.biały) ? "\u2658" : "\u265E";
    }
}
