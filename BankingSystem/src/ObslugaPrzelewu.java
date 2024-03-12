import java.util.Scanner;

public class ObslugaPrzelewu implements IObslugaPrzelewu {
    KontoBankowe konto;

    /**
     *
     * @param konto
     */
    public ObslugaPrzelewu(KontoBankowe konto){
        try{
            this.konto = konto;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param przelew
     * @return
     */
    public String sprawdzenie(Przelew przelew){
        String status = "NIEZNANY";
        String msg;
        double kwotaPrzelewu = przelew.getKwota() + przelew.getOplatyDodatkowe();

        Wyjatki wyjatek = new Wyjatki("");

        try{
            wyjatek.zbytMaloSrodkowNaKoncie(konto.getStanKonta(),kwotaPrzelewu);

            status = "ZAKSIĘGOWANO";

            konto.setStanKonta(konto.getStanKonta() - kwotaPrzelewu);
            msg = przelew.toString() + ", status: " + status;

        } catch (Wyjatki e){
            status = "NIEPOWODZENIE - " + e.getMessage() ;
            msg = przelew.getTytul() + " z konta " + konto.getNrKonta() + " na konto " + przelew.getKontoAdresata() + ", status: " + status;
        } finally {
            System.out.println(status);
        }

        return msg;
    }

    /**
     *
     * @param rodzaj
     * @param oplatyDodatkowe
     * @return
     */
    public String przelewyTemp(String rodzaj, double oplatyDodatkowe){
        String kontoAdresata;
        String tytulPrzelewu;
        double kwotaPrzelewu;

        Scanner s = new Scanner(System.in);

        System.out.println("Konto :\t" + konto.getNrKonta());
        System.out.print("Numer konta :\t");
        kontoAdresata = s.nextLine();
        System.out.print("Kwota przelewu :\t");
        kwotaPrzelewu = Double.parseDouble(s.nextLine());
        System.out.print("Tytuł przelewu :\t");
        tytulPrzelewu = s.nextLine();

        try{
            Przelew przelew = new Przelew(rodzaj, tytulPrzelewu, konto.getNrKonta(), kontoAdresata, konto.getKlientToString(), kwotaPrzelewu, oplatyDodatkowe);
            return sprawdzenie(przelew);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "EXCEPTION";
        }


    }

    /**
     *
     * @return
     */
    public String przelewWlasny(){
        return przelewyTemp("Przelew Własny",0.0);
    }

    /**
     *
     * @return
     */
    public String przelewZwykly(){
        return przelewyTemp("Przelew Zwykły",0.0);
    }

    /**
     *
     * @return
     */
    public String szybkaTranzakcja(){  // dodatkowa opłata
        return przelewyTemp("Szybka Tranzakcja",5.0);
    }

    /**
     *
     * @return
     */
    public String przelewZUS(){
        return przelewyTemp("Przelew ZUS",0.0);
    }

    /**
     *
     * @return
     */
    public String przelewUS(){
        return przelewyTemp("Przelew US",0.0);
    }

}
