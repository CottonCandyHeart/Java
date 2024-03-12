import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PracownikBOK extends Uzytkownik implements IKonto {
    private Klient klient;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param login
     * @param haslo
     * @param email
     */
    public PracownikBOK(String imie, String nazwisko, String pesel, String login, String haslo, String email){
        super(imie,nazwisko,pesel,login,haslo,email,"Pracownik Biura Obsługi Klienta");
    }

    // OBSŁUGA KLIENTA

    /**
     *
     * @param k
     */
    public void obsluzZgloszenie(Klient k){
        this.klient = k;
    }
    public void rozwiazProblem(){
        System.out.println("Wyszukiwanie problemów");

        for (int i=0; i < 101; i++){
            System.out.print(i + " ");
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\nNie znaleziono problemu. Miłego dnia");
    }
    public void udzielInformacji(){
        try{
            Scanner s = new Scanner(System.in);
            String pytanie;

            System.out.println("Zadaj nam pytanie!");
            pytanie = s.nextLine();
            System.out.println("Dziękujemy za to pytanie. Odpowiemy na nie mailem!");

        } catch (Exception e){
            System.out.println("Nie udało się zadać pytania - " + e.getMessage());
        }

    }
    public void historiaTranzakcjiKlienta(){
        try{
            KontoBankowe kb = klient.getKonto();
            kb.wyswietlHistorieTranzakcji();
        } catch (Exception e){
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
