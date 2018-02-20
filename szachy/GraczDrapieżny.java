package szachy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by RAFAŁ on 2017-01-30 21:55.
 */
public class GraczDrapieżny extends Gracz {

    public GraczDrapieżny(String imię) {
        super(imię);
    }

    @Override
    protected Ruch wybierzRuch(ArrayList<Ruch> listaRuchów) {
        ArrayList<Ruch> ruchyBijące = new ArrayList<>();
        Ruch wybranyRuch = null;
        for (Ruch ruch : listaRuchów) {
            if(ruch.czyBije()){
                ruchyBijące.add(ruch);
            }
        }
        if (ruchyBijące.isEmpty()){
            Random los = new Random();
            int wylosowanaLiczba = los.nextInt(listaRuchów.size());
            return listaRuchów.get(wylosowanaLiczba);
        } else {
            String[] figury = new String[]{"szachy.Król", "szachy.Hetman", "szachy.Wieża",
                    "szachy.Skoczek", "szachy.Goniec", "szachy.Pion"};
            ArrayList<Ruch> optymalneRuchy = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                for (Ruch ruch : ruchyBijące) {
                    if(ruch.kogoBije.getClass().getName() == figury[i]){
                        optymalneRuchy.add(ruch);
                    }
                }
                if (!optymalneRuchy.isEmpty()){
                    Random los = new Random();
                    int wylosowanaLiczba = los.nextInt(optymalneRuchy.size());
                    return optymalneRuchy.get(wylosowanaLiczba);
                }
            }
            return null;             // zaślepka; to się nie zdarzy
        }
    }
}
