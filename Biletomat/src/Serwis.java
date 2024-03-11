import java.time.Clock;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class Serwis implements ISerwis{
    private int licznikCzynnosciSerwisowych = 0;
    private Vector<String> rejestrCzynnosciSerwisowych;

    public Serwis(){
        rejestrCzynnosciSerwisowych = new Vector<String>();
    }

    // BILET
    public Bilet setBilet(Biletomat biletomat, Bilet b, double nowaCena){

        czynnoscSerwisowa("Aktualizacja ceny biletu " + b.toString() + " na " + nowaCena + "zl",biletomat);
        b.setCena(nowaCena);
        licznikCzynnosciSerwisowych++;
        return b;
    }

    public Bilet setCena(Biletomat biletomat, Bilet b, String nowyRodzaj){

        czynnoscSerwisowa("Aktualizacja typu biletu " + b.toString() + " na " + nowyRodzaj,biletomat);
        b.setRodzaj(nowyRodzaj);
        licznikCzynnosciSerwisowych++;
        return b;
    }

    // BILETOMAT
    public Vector<Bilet> dodajBilet(Biletomat biletomat, String rodzaj, double cena){
        Vector<Bilet> bilety = biletomat.getBilety();

        czynnoscSerwisowa("Dodanie nowego rodzaju biletu " + rodzaj + " " + cena + "zl", biletomat);
        Bilet b = new Bilet(rodzaj,cena);
        bilety.addElement(b);

        biletomat.setBilety(bilety);

        licznikCzynnosciSerwisowych++;
        return bilety;
    }

    public Biletomat iloscBlankietow (Biletomat b, int nowaIlosc){

        czynnoscSerwisowa("Aktualizacja ilosci blankietow " + b.getIloscBlankietow() + " na " + nowaIlosc, b);
        b.setBlankiety(nowaIlosc);
        licznikCzynnosciSerwisowych++;
        return b;
    }

    public Vector<Integer> zmienIloscMonet(Biletomat biletomat){
        Vector<Integer> monety = biletomat.getIloscMonet();

        Scanner s = new Scanner(System.in);

        for (int i=0; i<monety.size(); i++){
            System.out.print("Nowa ilosc monet " + (i+1) + " : ");
            monety.set(i,s.nextInt());
        }

        czynnoscSerwisowa("Aktualizacja ilosci monet. Aktualny stan: " + monety,biletomat);
        licznikCzynnosciSerwisowych++;

        return monety;
    }

    public void komunikatyOAwarii(Biletomat b,int blankiety, Vector<Integer> monety, boolean czyKontrola){
        String komunikat = "Automat czynny";
        if (czyKontrola){
            komunikat ="Automat nieczynny - prace serwisowe";
        } else if (blankiety == 0){
            komunikat ="Automat nieczynny - brak blankietow";
            System.exit(1);
        } else if (!b.zasilanie()) {
            komunikat ="Automat nieczynny - awaria zasilania";
            System.exit(1);
        } else {
            for (int i=0; i<monety.size(); i++){
                if (monety.indexOf(i) == 0){
                    komunikat ="Automat nieczynny - brak bilonu";
                    System.exit(1);
                }
            }
        }

        licznikCzynnosciSerwisowych++;
        System.out.println(komunikat);
        czynnoscSerwisowa("Aktualny stan biletomatu: " + komunikat,b);

        if (!komunikat.equals("Automat czynny")){
            System.exit(1);
        }

    }
    public String toString(Biletomat b){

        String komunikat = "";

        komunikat += (b.getLokalizacja() + " " + b.getIdentyfikator() + ", bilety: " + b.getBilety() + ", monety: ");

        for (int i : b.getIloscMonet()){
            komunikat += (i + ", ");
        }

        komunikat += "ilosc blankietow: " + b.getIloscBlankietow();

        licznikCzynnosciSerwisowych++;

        return komunikat;
    }

    public void czynnoscSerwisowa(String czynnosc, Biletomat b){

        Clock cl = Clock.systemUTC();
        LocalDate lt = LocalDate.now(cl);

        String komunikat = "" + lt + " " + b.getLokalizacja() + " " + b.getIdentyfikator() + " " + czynnosc + "\n";

        rejestrCzynnosciSerwisowych.add(komunikat);
    }

    public void wyswietlCzynnosciSerwisowe(LocalDate date){
        String strDate = "" + date;

        for (String tranzakcja : rejestrCzynnosciSerwisowych){
            if (tranzakcja.contains(strDate)){
                System.out.println(tranzakcja);
            }
        }
    }

}
