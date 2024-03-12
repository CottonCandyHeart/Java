public class ObslugaKredytu implements IObslugaKredytu {
    private String rodzajKredytu;
    private boolean czyPrzyznanoKredyt;
    private double wysokoscKredytu;

    /**
     *
     * @param rodzajKredytu
     * @param wysokoscKredytu
     */
    public ObslugaKredytu(String rodzajKredytu, double wysokoscKredytu){
        this.rodzajKredytu = rodzajKredytu;
        Wyjatki wyjatek = new Wyjatki("");
        try{
            this.wysokoscKredytu = wysokoscKredytu;
            wyjatek.kwotaNaMinusie(this.wysokoscKredytu);
        } catch (Wyjatki e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param trescWniosku
     */
    public void zlozWniosekKredytowy(String trescWniosku){
        System.out.println("Wniosek o kredyt wysłano!");
    }
    public void pozytywnaOdpowiedzSK(){
        czyPrzyznanoKredyt = true;
        System.out.println("Wniosek o kredyt przyjęto");
    }
    public void negatywnaOdpowiedzSK(){
        czyPrzyznanoKredyt = false;
        System.out.println("Wniosek o kredyt odrzucono");
    }

    /**
     *
     * @param rodzajKredytu
     */
    public void setRodzajKredytu(String rodzajKredytu) {
        this.rodzajKredytu = rodzajKredytu;
    }

    /**
     *
     * @return
     */
    public String getRodzajKredytu(){
        return rodzajKredytu;
    }

    /**
     *
     * @param wysokoscKredytu
     */
    public void setWysokoscKredytu(double wysokoscKredytu) {
        Wyjatki wyjatek = new Wyjatki("");
        try{
            this.wysokoscKredytu = wysokoscKredytu;
            wyjatek.kwotaNaMinusie(this.wysokoscKredytu);
        } catch (Wyjatki e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public double getWysokoscKredytu() {
        return wysokoscKredytu;
    }

}
