public class Main {

    public static void main(String[] args) {
        Klient klient = new Klient("Jan","Kowalski","00000000000","jkowalski","mojehaslo","kowal@gmail.com","000000000");
        Administrator administrator = new Administrator("Anna","Nowak","00000000000","anowak","mojehaslo","nowak@gmail.com");
        KierownikDzialu kierownikDzialu = new KierownikDzialu("Zygmunt","Hajzer","00000000000","hajzi123","mojehaslo","hajzer@gmail.com");
        PracownikBOK pracownikBOK = new PracownikBOK("Jolanta","Kocyk","00000000000","kocowna","mojehaslo","jolus@gmail.com");
        PracownikSK pracownikSK = new PracownikSK("Marek","Bryg","00000000000","bryczka999","mojehaslo","marek_bryg@gmail.com");

        klient.wyswietlProfil();
        System.out.println();
        administrator.wyswietlProfil();
        System.out.println();
        kierownikDzialu.wyswietlProfil();
        System.out.println();
        pracownikBOK.wyswietlProfil();
        System.out.println();
        pracownikSK.wyswietlProfil();
        System.out.println();

        klient.getKonto().setStanKonta(10000);
        klient.przelewZwykly();
        klient.szybkaTranzakcja();
        System.out.println();

        klient.getKonto().wyswietlHistorieTranzakcji();
        System.out.println();


        System.out.println("Złotówki : " + klient.getKonto().getStanKonta());
        System.out.println("Euro : " + klient.getKonto().getStanKontaEuro());
        System.out.println("Dolary : " + klient.getKonto().getStanKontaDolary());
        System.out.println();

        klient.wymianaWalut();

        System.out.println("Złotówki : " + klient.getKonto().getStanKonta());
        System.out.println("Euro : " + klient.getKonto().getStanKontaEuro());
        System.out.println("Dolary : " + klient.getKonto().getStanKontaDolary());
        System.out.println();

        kierownikDzialu.zarzadzajZespolem();
        kierownikDzialu.dodajRaport();
        kierownikDzialu.przegladajRaporty();
        System.out.println();

        pracownikBOK.rozwiazProblem();
        pracownikBOK.udzielInformacji();
        System.out.println();

        pracownikSK.wyswietlDostepneKredyty();
        pracownikSK.akceptujKredyt("Oferta 1",50000);
        System.out.println();

        Uzytkownik pSK = new PracownikSK("Marek","Bryg","00000000000","bryczka999","mojehaslo","marek_bryg@gmail.com");
        administrator.zarzadzajKontemUzytkownika(pSK);
        pSK.wyswietlProfil();
        administrator.nadajUprawnienia("Zarządca Sektora Kredytowego");
        System.out.println();
        pSK.wyswietlProfil();


    }
}
