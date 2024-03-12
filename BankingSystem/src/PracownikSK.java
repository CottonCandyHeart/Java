public class PracownikSK extends Uzytkownik implements IKonto {
    private String[] kredyty = {"Oferta 1","Oferta 2","Oferta 3","Oferta 4","Oferta 5"};
    private ObslugaKredytu ok;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     */
    public PracownikSK(String imie, String nazwisko, String pesel, String login, String haslo, String email){
        super(imie,nazwisko,pesel,login,haslo,email,"Pracownik Sektora Kredytowego");
    }

    // ZARZĄDZANIE KREDYTAMI
    public void wyswietlDostepneKredyty(){
        for (String oferta : kredyty){
            System.out.println(oferta);
        }
    }

    /**
     *
     * @param rodzaj
     * @param wysokoscKredytu
     */
    public void akceptujKredyt(String rodzaj, double wysokoscKredytu){
        try{
            ok = new ObslugaKredytu(rodzaj,wysokoscKredytu);
            ok.pozytywnaOdpowiedzSK();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param rodzaj
     * @param wysokoscKredytu
     */
    public void odrzucKredyt(String rodzaj, double wysokoscKredytu){
        try{
            ok = new ObslugaKredytu(rodzaj,wysokoscKredytu);
            ok.negatywnaOdpowiedzSK();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param trescMaila
     */
    public void komunikacjaZBIK(String trescMaila){
        System.out.println("Mail wysłany");
    }

    // OBSŁUGA PROFILU
    @Override
    public void wyswietlProfil(){
        System.out.println("Tytuł :\t" + super.getTytul());
        System.out.println("Imie :\t" + super.getImie());
        System.out.println("Nazwisko :\t" + super.getNazwisko());
        System.out.println("PESEL :\t" + super.getPESEL());
        System.out.println("Login :\t" + super.getLogin());
        System.out.println("E-mail :\t" + super.getEmail());
    }

    /**
     *
     * @param tytul
     */
    public void setTytul(String tytul) {
        super.setTytul(tytul);
    }

}
