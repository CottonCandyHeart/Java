import java.util.Vector;

public class KierownikDzialu extends Uzytkownik implements IKonto {
    private Vector<String> raporty;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     */
    public KierownikDzialu(String imie, String nazwisko, String pesel, String login, String haslo, String email){
        super(imie,nazwisko,pesel,login,haslo,email,"Kierownik Działu");
        try{
            raporty = new Vector<String>();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    // ZARZĄDZANIE ZESPOŁEM
    public void zarzadzajZespolem(){
        try{
            raporty.addElement("Wykonano zarządzanie zespołem");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void dodajRaport(){
        try{
            raporty.addElement("Raport z działań");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void przegladajRaporty(){
        for (String raport : raporty){
            System.out.println(raport);
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
     * @return
     */
    public Vector<String> getRaporty(){
        return raporty;
    }

    /**
     *
     * @param tytul
     */
    public void setTytul(String tytul) {
        super.setTytul(tytul);
    }
}
