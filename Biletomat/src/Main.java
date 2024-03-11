import java.time.Clock;
import java.time.LocalDate;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // wejciowa ilosc monet
        Vector<Integer> iloscMonet = new Vector<>();
        for (int i=0; i<6; i++){
            iloscMonet.addElement(100);
        }

        // utworzenie dwoch biletomatow
        Biletomat b = new Biletomat("Krakow","D910",1000,iloscMonet);
        Biletomat b2 = new Biletomat("Krakow","C716",1000,iloscMonet);

        b.status();
        System.out.println();
        b2.status();
        System.out.println();
        System.out.println();

        // dokonanie tranzakcji
        /*
        b.wykonajTransakcje();
        b.wykonajTransakcje();
        b.wykonajTransakcje();
        b.status();
        */

        // wykonanie czynnosci serwisowych
        Serwis serwis = new Serwis();
        serwis.dodajBilet(b,"7 dni norm",55);
        serwis.dodajBilet(b,"7 dni ulg",27.5);
        serwis.iloscBlankietow (b2,1500);

        b.status();
        System.out.println();
        b2.status();
        System.out.println();
        System.out.println();


        // lista tranzakcji i czynnosci serwisowych
        Clock cl = Clock.systemUTC();
        LocalDate lt = LocalDate.now(cl);

        //b.wydrukujTransakcje(lt);
        serwis.wyswietlCzynnosciSerwisowe(lt);


    }
}