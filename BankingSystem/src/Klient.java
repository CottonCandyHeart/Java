public class Klient extends Uzytkownik implements IKonto {
    private String nrTelefonu;
    private KontoBankowe konto;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     * @param nrTel
     */
    public Klient(String imie, String nazwisko, String pesel, String login, String haslo, String email, String nrTel){
        super(imie,nazwisko,pesel,login,haslo,email);
        Wyjatki wyjatek = new Wyjatki("");

        try{
            this.nrTelefonu = nrTel;
            wyjatek.niepoprawnyNumerTelefonu(this.nrTelefonu);
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }

        try{
            konto = new KontoBankowe(this);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    // OBSŁUGA PRZELEWÓW
    public void przelewWlasny(){
        konto.wykonajPrzelew(1);
    }
    public void przelewZwykly(){
        konto.wykonajPrzelew(2);
    }
    public void szybkaTranzakcja(){
        konto.wykonajPrzelew(3);
    }
    public void wymianaWalut(){
        konto.wykonajPrzelew(4);
    }
    public void przelewZUS(){
        konto.wykonajPrzelew(5);
    }
    public void przelewUS(){
        konto.wykonajPrzelew(6);
    }

    // OBSŁUGA PROFILU

    /**
     *
     * @return
     */
    public String toString(){
        return ("" + super.getImie() + " " + super.getNazwisko());
    }
    @Override
    public void wyswietlProfil(){
        System.out.println("Imie :\t" + super.getImie());
        System.out.println("Nazwisko :\t" + super.getNazwisko());
        System.out.println("PESEL :\t" + super.getPESEL());
        System.out.println("Login :\t" + super.getLogin());
        System.out.println("E-mail :\t" + super.getEmail());
        System.out.println("Numer Telefonu :\t" + nrTelefonu);
        konto.wyswietlStanKonta();
    }

    // SETTERY I GETTERY

    /**
     *
     * @param numer
     */
    public void setNrTelefonu(String numer){
        Wyjatki wyjatek = new Wyjatki("");
        try{
            wyjatek.niepoprawnyNumerTelefonu(this.nrTelefonu);
            this.nrTelefonu = numer;
        } catch (Wyjatki e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public String getNrTelefonu(){
        return this.nrTelefonu;
    }

    /**
     *
     * @return
     */
    public KontoBankowe getKonto() {
        return konto;
    }
}
