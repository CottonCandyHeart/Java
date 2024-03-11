import java.util.Vector;

public interface IPieniadz {
    double pozostalaKwota = 0;
    boolean przeprowadzTransakcje(boolean czyPin, Vector<Integer> monety, Biletomat b, int iloscBiletowKupionych);
}
