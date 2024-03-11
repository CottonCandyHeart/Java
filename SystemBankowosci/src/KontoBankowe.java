import java.util.Scanner;
import java.util.Vector;

public class KontoBankowe implements IKontoBankowe {
    private String nrKonta;
    private double stanKonta;
    private double stanKontaEuro;
    private double stanKontaDolary;
    private Vector<String> historiaPrzelewow;
    private Klient k;
    private double WARTOSC_EURO = 4.34;
    private double WARTOSC_DOLARA = 3.92;
    private double EURO_DOLAR = 0.9;

    /**
     *
     * @param k
     */
    public KontoBankowe(Klient k){
        this.nrKonta = "PL" + (Math.random()+100_000_000);
        this.k = k;
        this.stanKonta = 0;
        this.stanKontaEuro = 0;
        historiaPrzelewow = new Vector<String>();
    }

    // OBSŁUGA PRZELEWÓW

    /**
     *
     * @param rodzaj
     */
    public void wykonajPrzelew(int rodzaj){
        try{
            ObslugaPrzelewu op = new ObslugaPrzelewu(this);

            switch (rodzaj) {
                case 1:
                    historiaPrzelewow.addElement(op.przelewWlasny());
                    break;
                case 2:
                    historiaPrzelewow.addElement(op.przelewZwykly());
                    break;
                case 3:
                    historiaPrzelewow.addElement(op.szybkaTranzakcja());
                    break;
                case 4:
                    historiaPrzelewow.addElement(wymianaWalut());
                    break;
                case 5:
                    historiaPrzelewow.addElement(op.przelewZUS());
                    break;
                case 6:
                    historiaPrzelewow.addElement(op.przelewUS());
                    break;
                default:
                    System.out.print("Nie rozpoznano");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param nazwa
     * @return
     */
    public double wymienTemp(String nazwa){
        double waluta = 0.0;
        Scanner s = new Scanner(System.in);
        Wyjatki wyjatek = new Wyjatki("");

        System.out.print("Ile " + nazwa + " chcesz uzyskać? : ");
        try{
            waluta = Double.parseDouble(s.nextLine());
            wyjatek.kwotaNaMinusie(waluta);
            return waluta;
        }catch (Wyjatki e){
            System.out.println(e.getMessage());
            return 0.0;
        }

    }

    /**
     *
     * @param kwota
     * @return
     */
    public boolean sprawdzenie(double kwota){
        Wyjatki wyjatek = new Wyjatki("");
        try{
            wyjatek.zbytMaloSrodkowNaKoncie(stanKonta,kwota);
            return true;
        } catch (Wyjatki e){
            historiaPrzelewow.addElement("Wymiana waluty, status : NIEPOWODZENIE - " + e.getMessage());
            return false;
        }

    }

    /**
     *
     * @return
     */
    public String wymianaWalut(){
        int wybor = 0;
        double pierwszaWaluta;
        double drugaWaluta;
        String msg = "NIEZNANY";

        System.out.println("Wymiana:\n\t1. PLN na Euro\n\t2. PLN na Dolary\n\t3. Euro na PLN\n\t4. Dolary na PLN");
        System.out.println("\t5. Euro na Dolary\n\t6. Dolary na Euro");

        Scanner s = new Scanner(System.in);
        try{
            wybor = Integer.parseInt(s.nextLine());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


        switch(wybor){
            case 1: // PLN na Euro
                drugaWaluta = wymienTemp("Euro");
                pierwszaWaluta = drugaWaluta * WARTOSC_EURO;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKonta -= pierwszaWaluta;
                    stanKontaEuro += drugaWaluta;
                    msg = "Wymiana - PLN : " + pierwszaWaluta + " na Euro : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            case 2: // PLN na Dolary
                drugaWaluta = wymienTemp("Dolary");
                pierwszaWaluta = drugaWaluta * WARTOSC_DOLARA;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKonta -= pierwszaWaluta;
                    stanKontaDolary += drugaWaluta;
                    msg = "Wymiana - PLN : " + pierwszaWaluta + " na Dolary : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            case 3: // Euro na PLN
                drugaWaluta = wymienTemp("PLN");
                pierwszaWaluta = drugaWaluta / WARTOSC_EURO;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKontaEuro -= pierwszaWaluta;
                    stanKonta+= drugaWaluta;
                    msg = "Wymiana - Euro : " + pierwszaWaluta + " na PLN : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            case 4: // Dolary na PLN
                drugaWaluta = wymienTemp("PLN");
                pierwszaWaluta = drugaWaluta / WARTOSC_DOLARA;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKontaDolary -= pierwszaWaluta;
                    stanKonta+= drugaWaluta;
                    msg = "Wymiana - Dolary : " + pierwszaWaluta + " na PLN : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            case 5: // Euro na Dolary   -> 1 Dolar = 0.9 Euro
                drugaWaluta = wymienTemp("Dolary");
                pierwszaWaluta = drugaWaluta * EURO_DOLAR;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKontaDolary -= pierwszaWaluta;
                    stanKonta+= drugaWaluta;
                    msg = "Wymiana - Euro : " + pierwszaWaluta + " na Dolary : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            case 6: // Dolary na Euro   -> 1 Dolar = 0.9 Euro
                drugaWaluta = wymienTemp("Dolary");
                pierwszaWaluta = drugaWaluta / EURO_DOLAR;

                if (sprawdzenie(pierwszaWaluta)){
                    stanKontaDolary -= pierwszaWaluta;
                    stanKonta+= drugaWaluta;
                    msg = "Wymiana - Dolary : " + pierwszaWaluta + " na Euro : " + drugaWaluta + ", status : WYKONANO POMYŚLNIE";
                }
                break;
            default:
                System.out.println("Nie rozpoznano");

        }

        return msg;
    }


    // ZARZĄDZANIE KONTEM
    public void wyswietlStanKonta(){
        System.out.println("Stan konta :\t" + stanKonta);
    }
    public void wyswietlHistorieTranzakcji(){
        for (String pozycja : historiaPrzelewow){
            System.out.println(pozycja);
        }
    }

    // SETTERY I GETTERY

    /**
     *
     * @param nrKonta
     */
    public void setNrKonta(String nrKonta){
        this.nrKonta = nrKonta;
    }

    /**
     *
     * @return
     */
    public String getNrKonta() {
        return nrKonta;
    }

    /**
     *
     * @param wartosc
     */
    public void setStanKonta(double wartosc){
        this.stanKonta = wartosc;
    }

    /**
     *
     * @return
     */
    public double getStanKonta(){
        return stanKonta;
    }

    /**
     *
     * @param stanKontaEuro
     */
    public void setStanKontaEuro(double stanKontaEuro) {
        this.stanKontaEuro = stanKontaEuro;
    }

    /**
     *
     * @return
     */
    public double getStanKontaEuro(){
        return this.stanKontaEuro;
    }

    /**
     *
     * @return
     */
    public double getStanKontaDolary(){
        return this.stanKontaDolary;
    }

    /**
     *
     * @param stanKontaDolary
     */
    public void setStanKontaDolary(double stanKontaDolary){
        this.stanKontaDolary = stanKontaDolary;
    }

    /**
     *
     * @return
     */
    public String getKlientToString(){
        return k.toString();
    }
}
