import szachy.*;

/**
 * Created by RAFAŁ on 2017-01-22 15:43.
 */
public class Szachy{

    public static void main(String[] args) {

        //
        // Testowanie rozgrywki!!!!
        //
        GraczDrapieżny g1 = new GraczDrapieżny("Rafcik");
        GraczLosowy g2 = new GraczLosowy("Java");
        Rozgrywka rozgrywka = new Rozgrywka(g1, g2);
        rozgrywka.rozpocznij();



//        System.out.println("Zaczynamy.");
//        Szachownica s = new Szachownica();
//        System.out.println("Wypisuję szachownicę pierwszy raz:");
//        System.out.println(s);
//        System.out.println("Szachownica wypisana pierwszy raz.");
//        int i = 3, j = 3;
//        System.out.println("Wstawiam Króla na (pola[" + i + "][" + j + "])");
//        Król król = new Król(Kolor.biały);
//        s.pola[i][j].dodajBierkę(król);
//        System.out.println("Wypisuję szachownicę drugi raz (z królem):");
//        System.out.println(s);
//        System.out.println("Szachownica wypisana drugi raz.");
//        System.out.println("Możliwe ruchy króla: " + król.podajMożliweRuchy());
//        System.out.println("Teraz mamy Starcie Królów!");
//        int di = 1, dj = 1;
//        Król królCzarny = new Król(Kolor.czarny);
//        s.pola[i + di][j + dj].dodajBierkę(królCzarny);
//        System.out.println(s);
//        System.out.println("Możliwe ruchy króla: " + król.podajMożliweRuchy());
//        System.out.println("Możliwe ruchy królaCzarnego: " + królCzarny.podajMożliweRuchy());
//
//        Król królBiałyPomocniczy = new Król(Kolor.biały);
//        s.pola[i - di][j - dj].dodajBierkę(królBiałyPomocniczy);
//        System.out.println(s);
//        System.out.println("Możliwe ruchy króla: " + król.podajMożliweRuchy());
//        System.out.println(s.pola[i][j].czyWolne());
//        System.out.println(s.pola[i + di][j + dj].czyWolne());
//        System.out.println(s.pola[i - di][j - dj].czyWolne());
//        Ruch ruch = new Ruch(s.pola[i][j], s.pola[i+1][j+1]);
//        System.out.println(s.toString());
//        System.out.println("ruch.wykonajSię()!");
//        ruch.wykonajSię();
//        System.out.println(s.toString());
//        s.pola[0][1].dodajBierkę(new Król(Kolor.biały));
//        s.pola[1][0].dodajBierkę(new Król(Kolor.czarny));
//        System.out.println(s.toString());
//
//        Szachownica s2 = new Szachownica();
//        System.out.println(s2.toString());
//        s2.rozstawBierki();
//        System.out.println(s2.toString());

//        GraczLosowy zenek = new GraczLosowy("Zenon Parufka");
//        zenek.kolor = Kolor.biały;
//        System.out.println(zenek);

//        // testowanie podawania ruchów przez Wieżę
//        Szachownica s3 = new Szachownica();
//        Wieża w = new Wieża(Kolor.biały);
//        s3.pola[1][1].dodajBierkę(new Król(Kolor.biały));
//        s3.pola[3][0].dodajBierkę(new Król(Kolor.biały));
//        s3.pola[3][3].dodajBierkę(w);
//        s3.pola[0][2].dodajBierkę(new Król(Kolor.czarny));
//        System.out.println(s3.toString());
//        System.out.println(w.podajMożliweRuchy());
//
//
//        // testowanie podawania ruchów przez Gońca
//        Szachownica s4 = new Szachownica();
//        Goniec g = new Goniec(Kolor.biały);
//        s4.pola[0][2].dodajBierkę(new Król(Kolor.biały));
//        s4.pola[3][1].dodajBierkę(new Król(Kolor.biały));
//        s4.pola[2][2].dodajBierkę(g);
//        s4.pola[4][4].dodajBierkę(new Król(Kolor.czarny));
//        System.out.println(s4.toString());
//        System.out.println(g.podajMożliweRuchy());
//
//
//        // testowanie podawania ruchów przez Gońca
//        Szachownica s5 = new Szachownica();
//        Hetman h = new Hetman(Kolor.biały);
//        s5.pola[0][2].dodajBierkę(new Król(Kolor.biały));
//        s5.pola[2][0].dodajBierkę(new Król(Kolor.biały));
//        s5.pola[1][1].dodajBierkę(h);
//        s5.pola[2][2].dodajBierkę(new Król(Kolor.czarny));
//        System.out.println(s5.toString());
//        System.out.println(h.podajMożliweRuchy());



//        // testowanie podawania ruchów przez Piona
//        Szachownica s6 = new Szachownica();
//        Pion p = new Pion(Kolor.czarny);
//        s6.pola[2][2].dodajBierkę(new Król(Kolor.biały));
//        s6.pola[3][3].dodajBierkę(p);
//        s6.pola[2][4].dodajBierkę(new Król(Kolor.biały));
//        System.out.println(s6.toString());
//        System.out.println(p.podajMożliweRuchy());






//        Pole pole56 = new Pole(5, 6, new Szachownica());
//        System.out.println(pole56.jakaBierka());
    }
}















