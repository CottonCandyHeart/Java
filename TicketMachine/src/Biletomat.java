import java.time.Clock;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class Biletomat implements IBiletomat {
    private Vector<Bilet> bilety;  // [0]-20min norm, [1]-20min ulg, [2]-60min norm, [3]-60min ulg
                                   //      4zł            2zł             7zł             3,5zł
    private String lokalizacja;
    private Vector<String> rejestrTranzakcji;
    private int iloscBlankietow;
    private Vector<Integer> iloscMonet;   // [0]-10gr, [1]-20gr, [2]-50gr, [3]-1zl, [4]-2zl, [5]-5zl
    private int liczbaPlatnosciKarta = 0;
    private int liczbaPlatnosciGotowka = 0;
    String zakup = "";
    private String identyfikator;

    public Biletomat(String lokalizacja, String identyfikator, int iloscBlankietow, Vector<Integer> iloscMonet) {
        this.lokalizacja = lokalizacja;
        this.identyfikator = identyfikator;
        this.iloscBlankietow = iloscBlankietow;
        this.iloscMonet = iloscMonet;

        rejestrTranzakcji = new Vector<String>();
        bilety = new Vector<>();

        Bilet bil = new Bilet("20min norm",4);
        bilety.addElement(bil);

        bil = new Bilet("20min ulg",2);
        bilety.addElement(bil);

        bil = new Bilet("60min norm",7);
        bilety.addElement(bil);

        bil = new Bilet("60min ulg",3.5);
        bilety.addElement(bil);
    }

    public void pokazBilety(){  // pokazuje dostepne bilety
        int i = 0;
        for (Bilet b : bilety){
            i++;
            System.out.println(i + ". " + b.toString());
        }
    }

    public String toString(LocalDate date,int[] bilet){

        double koszt = 0;
        double suma = 0;
        int iloscBiletowKupionych = 0;

        for (int i=0; i<bilet.length; i++){
            koszt += (bilety.elementAt(i).getCena()*bilet[i]);
            suma += koszt;
            iloscBiletowKupionych += bilet[i];
            this.zakup += (date + " : " + bilety.elementAt(i).getRodzaj() + " : " + bilet[i] + "szt. : " + koszt + "zl ");
            koszt = 0;
        }

        if (dokonajZakupu(suma, iloscBiletowKupionych)){
            rejestrTranzakcji.add(this.zakup);
        } else {
            System.out.println("Nie udalo sie dokonac tranzakcji. Sproboj ponownie");
        }

        return this.zakup;
    }

    public void wykonajTransakcje(){
        // create a clock
        Clock cl = Clock.systemUTC();
        // create an LocalDate object using now(Clock)
        LocalDate lt = LocalDate.now(cl);

        Scanner s = new Scanner(System.in);
        int nrBiletu, ilosc;
        double suma;

        int[] zakup = new int[bilety.size()];
        for (int i=0; i<bilety.size(); i++){
            zakup[i] = 0;
        }

        String stop = "n";

        pokazBilety();

        do{
            System.out.print("Wybierz bilet [1-4] : ");
            nrBiletu = Integer.parseInt(s.nextLine());
            System.out.print("Podaj ilosc : ");
            ilosc = Integer.parseInt(s.nextLine());

            zakup[nrBiletu-1] += ilosc;

            System.out.print("Czy chcesz dodac kolejny bilet? (t/n) : ");
            stop = s.nextLine().toLowerCase();

        } while (!stop.equals("n") && !stop.equals("nie"));

        System.out.println("Twoj zakup:\n" + this.toString(lt,zakup));
        this.zakup = "";

    }

    public void wydrukujTransakcje(LocalDate date){
        String strDate = "" + date;

        for (String tranzakcja : rejestrTranzakcji){
            if (tranzakcja.contains(strDate)){
                System.out.println(tranzakcja);
            }
        }
    }

    public boolean dokonajZakupu(double koszt,int iloscBiletowKupionych){
        Pieniadz p = new Pieniadz("gotowka",0);
        String metoda;
        Scanner s = new Scanner(System.in);
        String pin = "";
        boolean czyPin;

        System.out.print("Metoda zakupu:\t");
        metoda = s.nextLine().toLowerCase();

        switch (metoda){
            case "karta":
                liczbaPlatnosciKarta++;
                zakup += " Platnosc karta\n";
                System.out.print("PIN (tak/nie):\t");
                pin = s.nextLine().toLowerCase();
                p = new Pieniadz(metoda,koszt);
                break;
            case "gotowka":
                liczbaPlatnosciGotowka++;
                zakup += " Platnosc gotowka\n";
                p = new Pieniadz(metoda,koszt);
                break;
            default:
                System.out.println("Nie rozpoznano");
        }

        if (pin.equals("tak") || pin.equals("t"))
            czyPin = true;
        else
            czyPin = false;

        return p.przeprowadzTransakcje(czyPin, iloscMonet, this, iloscBiletowKupionych);

    }
    public void setBlankiety(int nowaIlosc){
        iloscBlankietow = nowaIlosc;
    }

    public void setMonety(int nowaIlosc, int index){
        this.iloscMonet.set(index, nowaIlosc);
    }
    public void setBilety(Vector<Bilet> bilety){
        this.bilety = bilety;
    }

    public boolean zasilanie(){
        return true;
    }

    public Vector<Bilet> getBilety (){
        return this.bilety;
    }
    public String getLokalizacja(){
        return this.lokalizacja;
    }
    public String getIdentyfikator(){return this.identyfikator;}
    public int getIloscBlankietow(){
        return this.iloscBlankietow;
    }
    public Vector<Integer> getIloscMonet (){
        return this.iloscMonet;
    }

    public void status(){
        Serwis s = new Serwis();

        System.out.println(s.toString(this));
        System.out.println("Tranzakcje karta:\t" + liczbaPlatnosciKarta);
        System.out.println("Tranzakcje gotowka:\t" + liczbaPlatnosciGotowka);

    }

}
