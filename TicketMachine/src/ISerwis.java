import java.time.LocalDate;
import java.util.Vector;

public interface ISerwis {
    int licznikCzynnosciSerwisowych = 0;
    Vector<String> rejestrCzynnosciSerwisowych = null;

    void komunikatyOAwarii(Biletomat b,int blankiety, Vector<Integer> monety, boolean czyKontrola);
    String toString(Biletomat b);
    void czynnoscSerwisowa(String czynnosc, Biletomat b);
    void wyswietlCzynnosciSerwisowe(LocalDate date);
}
