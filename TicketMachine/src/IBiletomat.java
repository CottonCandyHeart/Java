import java.time.LocalDate;
import java.util.Vector;

public interface IBiletomat {
    Vector<Bilet> bilety = null;
    String lokalizacja = "NULL";
    Vector<String> rejestrTranzakcji = null;
    int iloscBlankietow = 0;
    Vector<Integer> iloscMonet = null;
    int liczbaPlatnosciKarta = 0;
    int liczbaPlatnosciGotowka = 0;
    String identyfikator = "NULL";

    String toString(LocalDate date, int[] bilet);
    void wykonajTransakcje();
    boolean dokonajZakupu(double koszt,int iloscBiletowKupionych);
    void setBlankiety(int nowaIlosc);

    void setMonety(int nowaIlosc, int index);
    void setBilety(Vector<Bilet> bilety);
    Vector<Bilet> getBilety ();
    String getLokalizacja();
    String getIdentyfikator();
    int getIloscBlankietow();
    Vector<Integer> getIloscMonet ();
    void status();

}
