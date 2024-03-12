import java.util.Vector;

public interface IKontoBankowe {
    String nrKonta = "PL0000000";
    double stanKonta = 0.0;
    Vector<String> historiaPrzelewow = null;

    // WYKONANIE PRZELEWU

    /**
     *
     * @param rodzaj
     */
    void wykonajPrzelew(int rodzaj);

    // ZARZĄDZANIE KONTEM
    void wyswietlStanKonta();

    // SETTERY I GETTERY

    /**
     *
     * @param nrKonta
     */
    void setNrKonta(String nrKonta);

    /**
     *
     * @return
     */
    String getNrKonta();

    /**
     *
     * @param wartosc
     */
    void setStanKonta(double wartosc);

    /**
     *
     * @return
     */
    double getStanKonta();
}
