import java.util.Scanner;
import java.util.Vector;

public class Pieniadz extends SrodekPlatnosci implements IPieniadz {
    public double pozostalaKwota = super.kwota;
    public Pieniadz(String rodzaj, double kwota) {
        super(rodzaj,kwota);
    }

    public boolean przeprowadzTransakcje(boolean czyPin, Vector<Integer> monety, Biletomat b, int iloscBiletowKupionych){

        double wrzuconaMoneta;
        Scanner s = new Scanner(System.in);

        if (b.getIloscBlankietow() >= iloscBiletowKupionych){


            if (super.rodzaj.equals("gotowka")){
                while (true){
                    wrzuconaMoneta = s.nextDouble();  // WRZUCENIE MONETY DO AUTOMATU

                    switch (""+wrzuconaMoneta){
                        case "0.1":
                            b.setMonety(monety.elementAt(0) + 1, 0);
                            break;
                        case "0.2":
                            b.setMonety(monety.elementAt(1) + 1, 1);
                            break;
                        case "0.5":
                            b.setMonety(monety.elementAt(2) + 1, 2);
                            break;
                        case "1.0":
                            b.setMonety(monety.elementAt(3) + 1, 3);
                            break;
                        case "2.0":
                            b.setMonety(monety.elementAt(4) + 1, 4);
                            break;
                        case "5.0":
                            b.setMonety(monety.elementAt(5) + 1, 5);
                            break;

                    }

                    monety = b.getIloscMonet();

                    if (wrzuconaMoneta < pozostalaKwota) {
                        pozostalaKwota -= wrzuconaMoneta;
                        System.out.println("Pozostało do zaplaty:\t" + pozostalaKwota);
                    } else {
                        pozostalaKwota -= wrzuconaMoneta;
                        System.out.println("Tranzakcja dokonana. Bilet w trakcie wydruku.");

                        if (pozostalaKwota < 0){
                            pozostalaKwota = (pozostalaKwota*(-1.0));
                            System.out.println("Reszta do wydania:\t" + pozostalaKwota);

                            while (pozostalaKwota > 0){
                                if (pozostalaKwota >= 5){
                                    b.setMonety(monety.elementAt(5) - 1, 5);
                                    pozostalaKwota -= 5;
                                } else if (pozostalaKwota >= 2){
                                    b.setMonety(monety.elementAt(4) - 1, 4);
                                    pozostalaKwota -= 2;
                                } else if (pozostalaKwota >= 1){
                                    b.setMonety(monety.elementAt(3) - 1, 3);
                                    pozostalaKwota -= 1;
                                } else if (pozostalaKwota >= 0.5){
                                    b.setMonety(monety.elementAt(2) - 1, 2);
                                    pozostalaKwota -= 0.5;
                                } else if (pozostalaKwota >= 0.2){
                                    b.setMonety(monety.elementAt(1) - 1, 1);
                                    pozostalaKwota -= 0.2;
                                } else {
                                    b.setMonety(monety.elementAt(0) - 1, 0);
                                    pozostalaKwota -= 0.1;
                                }
                            }
                        }else{
                            System.out.println("Brak reszty.");
                        }

                        return true;
                    }
                }

            } else {
                if (czyPin){
                    String pin;
                    System.out.print("Wprowadź PIN:\t");
                    pin = s.nextLine();

                    if (super.czyPinPoprawny(pin))
                        System.out.println("Tranzakcja dokonana.");
                    else{
                        System.out.println("Tranzakcja odrzucona.");
                        return false;
                    }


                } else {
                    if (super.czyKartaPrzylozona())
                        System.out.println("Tranzakcja dokonana.");
                    else{
                        System.out.println("Tranzakcja odrzucona.");
                        return false;
                    }
                }
            }

            b.setBlankiety(b.getIloscBlankietow() - iloscBiletowKupionych);
        } else {
            System.out.println("Brak blankietow");
            return false;
        }

        return true;

    }
}
