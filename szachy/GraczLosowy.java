package szachy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by RAFAŁ on 2017-01-27 15:23.
 */
public class GraczLosowy extends Gracz {

    public GraczLosowy(String imię) {
        super(imię);
    }

    @Override
    protected Ruch wybierzRuch(ArrayList<Ruch> listaRuchów) {
        Random los = new Random();
        int wylosowanaLiczba = los.nextInt(listaRuchów.size());
        return listaRuchów.get(wylosowanaLiczba);
    }
}
