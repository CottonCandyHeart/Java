public class Wyjatki  extends RuntimeException {
    private String errorMessage;

    /**
     *
     * @param errorMessage
     */
    public Wyjatki (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @param stanKonta
     * @param kwota
     */
    public void zbytMaloSrodkowNaKoncie(double stanKonta, double kwota) {
        if (stanKonta - kwota < 0)
            throw new Wyjatki("Zbyt mało środków na koncie");
    }

    /**
     *
     * @param kwota
     */
    public void kwotaNaMinusie(double kwota) {
        if (kwota < 0)
            throw new Wyjatki("Kwota ujemna");
    }

    /**
     *
     * @param nrTelefonu
     */
    public void niepoprawnyNumerTelefonu(String nrTelefonu) {
        if (nrTelefonu.length() != 9)
            throw new Wyjatki("Niepoprawny numer telefonu");
    }

    /**
     *
     * @param PESEL
     */
    public void niepoprawnyNumerPESEL(String PESEL) {
        if (PESEL.length() != 11)
            throw new Wyjatki("Niepoprawny numer PESEL");
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return errorMessage;
    }

}