public class Administrator extends Uzytkownik implements IKonto {
    Uzytkownik klient;

    /**
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     */
    public Administrator(String imie, String nazwisko, String pesel, String login, String haslo, String email){
        super(imie,nazwisko,pesel,login,haslo,email,"Administrator");
    }

    // ZARZĄDZANIE KONTAMI

    /**
     *
     * @param k
     */
    public void zarzadzajKontemUzytkownika(Uzytkownik k){
        try{
            klient = k;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param noweUprawnienia
     */
    public void nadajUprawnienia(String noweUprawnienia){
        try{
            klient.setTytul(noweUprawnienia);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void moniturujDzialania(){
        try{
            klient.wyswietlProfil();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

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
