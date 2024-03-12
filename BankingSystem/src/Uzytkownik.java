public class Uzytkownik implements IKonto{
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String login;
    private String haslo;
    private String email;
    private String tytul;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     */
    public Uzytkownik(String imie, String nazwisko, String pesel, String login, String haslo, String email){
        Wyjatki wyjatek = new Wyjatki("");

        this.imie = imie;
        this.nazwisko = nazwisko;
        try{
            this.PESEL = pesel;
            wyjatek.niepoprawnyNumerPESEL(this.PESEL);
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }
        this.login = login;
        this.haslo = haslo;
        this.email = email;
    }

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     * @param tytul
     */
    public Uzytkownik(String imie, String nazwisko, String pesel, String login, String haslo, String email, String tytul){
        Wyjatki wyjatek = new Wyjatki("");

        this.imie = imie;
        this.nazwisko = nazwisko;
        try{
            this.PESEL = pesel;
            wyjatek.niepoprawnyNumerPESEL(this.PESEL);
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.tytul = tytul;
    }

    public void wyswietlProfil(){}

    /**
     *
     * @return
     */
    public String getImie() {
        return imie;
    }

    /**
     *
     * @return
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     *
     * @return
     */
    public String getPESEL() {
        return PESEL;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @return
     */
    public String getHaslo() {
        return haslo;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getTytul(){
        return tytul;
    }

    /**
     *
     * @param imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     *
     * @param nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     *
     * @param PESEL
     */
    public void setPESEL(String PESEL) {
        Wyjatki wyjatek = new Wyjatki("");
        try{
            this.PESEL = PESEL;
            wyjatek.niepoprawnyNumerPESEL(this.PESEL);
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @param haslo
     */
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param tytul
     */
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
