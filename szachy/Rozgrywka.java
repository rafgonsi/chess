package szachy;

import java.util.ArrayList;

/**
 * Created by RAFAŁ on 2017-01-27 15:37.
 */
public class Rozgrywka {

    private Gracz białe;
    private Gracz czarne;
    private Szachownica szachownica;
    private boolean czyGraSkończona;
    private int maksymalnaLiczbaTur = 50;
    private Gracz zwycięzca;

    public Rozgrywka(Gracz białe, Gracz czarne) {
        this.białe = białe;
        this.czarne = czarne;
        this.szachownica = new Szachownica();
        this.czyGraSkończona = false;
        this.zwycięzca = null;

        this.białe.kolor = Kolor.biały;
        this.czarne.kolor = Kolor.czarny;// konstruktor gracza zostawił zadanie
                                        // określenia koloru graczawłaśnie rozgrywce
    }

    public void rozpocznij(){
        int tura = 1;
        System.out.println(białe + " vs " + czarne);
        System.out.println(szachownica);

        while(tura <= maksymalnaLiczbaTur){
            System.out.println("------------/ Tura " + tura + " /------------");
            wykonajRuch(białe);
            System.out.println(szachownica);
            if(czyGraSkończona){
                break;
            }
            wykonajRuch(czarne);
            System.out.println(szachownica);
            if(czyGraSkończona) {
                break;
            }
            tura++;
        }

        if (tura > maksymalnaLiczbaTur){
            System.out.println("Partia " + białe + " vs " + czarne
                    + " zakończona remisem po upływie " + maksymalnaLiczbaTur + " tur.");
        } else {
            System.out.println("Partia zakończona. Zwycięzcą jest " + zwycięzca + ".");
        }
    }

    private void wykonajRuch(Gracz gracz) {
        ArrayList<Ruch> listaRuchów = podajMożliweRuchy(gracz); // lista dostępnych ruchów
        if (listaRuchów.isEmpty()){
            // lista ruchów jest pusta. Ten gracz nie może się poruszyć więc przegrywa.
            czyGraSkończona = true;
            if(gracz.kolor == Kolor.biały){
                zwycięzca = czarne;
            } else {
                zwycięzca = białe;
            }
        } else { // listaRuchów jest niepusta
            Ruch wybranyRuch = gracz.wybierzRuch(listaRuchów); // gracz wybiera ruch z listy
            wybranyRuch.wykonajSię(); // następuje wykonanie ruchu
            System.out.println(wybranyRuch);
            if (wybranyRuch.czyWygrywa()){
                czyGraSkończona = true;
                zwycięzca = gracz;
            }
        }
    }

    private ArrayList<Ruch> podajMożliweRuchy(Gracz gracz){
        ArrayList<Ruch> listaRuchów = new ArrayList<>();
        Kolor kolor = gracz.kolor;
        // szukamy Bierek tego Koloru i pytamy je o ich możliwe ruchy. Potem sklejamy te listy w całość.
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(!szachownica.pola[i][j].czyWolne()){
                    if(szachownica.pola[i][j].jakaBierka().jakiKolor() == kolor){
                        listaRuchów.addAll(szachownica.pola[i][j].jakaBierka().podajMożliweRuchy());
                    }
                }
            }
        }
        return listaRuchów;
    }

}
