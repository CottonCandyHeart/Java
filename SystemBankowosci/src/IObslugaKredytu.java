public interface IObslugaKredytu {
    String rodzajKredytu = "";
    boolean czyPrzyznanoKredyt = false;
    double wysokoscKredytu = 0.0;

    /**
     *
     * @param trescWniosku
     */
    void zlozWniosekKredytowy(String trescWniosku);
    void pozytywnaOdpowiedzSK();
    void negatywnaOdpowiedzSK();

    /**
     *
     * @param rodzajKredytu
     */
    void setRodzajKredytu(String rodzajKredytu);

    /**
     *
     * @return
     */
    String getRodzajKredytu();

    /**
     *
     * @param wysokoscKredytu
     */
    void setWysokoscKredytu(double wysokoscKredytu);

    /**
     *
     * @return
     */
    double getWysokoscKredytu();
}
