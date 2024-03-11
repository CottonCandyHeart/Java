import java.util.Vector;

public abstract class SrodekPlatnosci {
    public String rodzaj;
    public double kwota;

    public SrodekPlatnosci(String rodzaj, double kwota) {
        this.rodzaj = rodzaj;
        this.kwota = kwota;
    }

    public String toString() {
        return "Rodzaj: " + rodzaj + ", Kwota: " + kwota;
    }

    public abstract boolean przeprowadzTransakcje(boolean czyPin, Vector<Integer> monety, Biletomat b, int iloscBiletowKupionych);

    public boolean czyPinPoprawny(String pin){
        return true;
    }

    public boolean czyKartaPrzylozona(){
        return true;
    }
}