public class Przelew implements IPrzelew {
    private String rodzaj;
    private String tytul;
    private String kontoNadawcy;
    private String kontoAdresata;
    private String daneAdresata;
    private double kwota;
    private double oplatyDodatkowe;

    /**
     *
     * @param rodzaj
     * @param tytul
     * @param kontoNadawcy
     * @param kontoAdresata
     * @param daneAdresata
     * @param kwota
     * @param oplatyDodatkowe
     */
    public Przelew(String rodzaj, String tytul, String kontoNadawcy, String kontoAdresata, String daneAdresata, double kwota, double oplatyDodatkowe) {

        Wyjatki wyjatek = new Wyjatki("");

        this.rodzaj = rodzaj;
        this.tytul = tytul;
        this.kontoNadawcy = kontoNadawcy;
        this.kontoAdresata = kontoAdresata;
        this.daneAdresata = daneAdresata;
        try{
            wyjatek.kwotaNaMinusie(kwota);
            this.kwota = kwota;
            wyjatek.kwotaNaMinusie(oplatyDodatkowe);
            this.oplatyDodatkowe = oplatyDodatkowe;
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }


    }

    /**
     *
     * @return
     */
    public String toString(){
        String msg = "";
        msg += rodzaj + " z konta " + kontoNadawcy + " na konto " + kontoAdresata;
        msg += ", " + daneAdresata;
        msg += ", kwota : " + kwota + ", opłaty dodatkowe : " + oplatyDodatkowe;
        msg += ", tytułem : " + tytul;

        return msg;
    }

    // GETTERY I SETTERY

    /**
     *
     * @return
     */
    public String getRodzaj() {
        return rodzaj;
    }

    /**
     *
     * @param rodzaj
     */
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    /**
     *
     * @return
     */
    public String getTytul() {
        return tytul;
    }

    /**
     *
     * @param tytul
     */
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    /**
     *
     * @return
     */
    public String getKontoNadawcy() {
        return kontoNadawcy;
    }

    /**
     *
     * @param kontoNadawcy
     */
    public void setKontoNadawcy(String kontoNadawcy) {
        this.kontoNadawcy = kontoNadawcy;
    }

    /**
     *
     * @return
     */
    public String getKontoAdresata() {
        return kontoAdresata;
    }

    /**
     *
     * @param kontoAdresata
     */
    public void setKontoAdresata(String kontoAdresata) {
        this.kontoAdresata = kontoAdresata;
    }

    /**
     *
     * @return
     */
    public String getDaneAdresata() {
        return daneAdresata;
    }

    /**
     *
     * @param daneAdresata
     */
    public void setDaneAdresata(String daneAdresata) {
        this.daneAdresata = daneAdresata;
    }

    /**
     *
     * @return
     */
    public double getKwota() {
        return kwota;
    }

    /**
     *
     * @param kwota
     */
    public void setKwota(double kwota) {
        Wyjatki wyjatek = new Wyjatki("");
        try{
            wyjatek.kwotaNaMinusie(kwota);
            this.kwota = kwota;
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public double getOplatyDodatkowe() {
        return oplatyDodatkowe;
    }

    /**
     *
     * @param oplatyDodatkowe
     */
    public void setOplatyDodatkowe(double oplatyDodatkowe) {
        Wyjatki wyjatek = new Wyjatki("");
        try{
            wyjatek.kwotaNaMinusie(oplatyDodatkowe);
            this.oplatyDodatkowe = oplatyDodatkowe;
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }
    }
}
