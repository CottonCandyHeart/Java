public class Bilet implements IBilet {
    private String rodzajBiletu;
    private double cena;

    public Bilet(String rodzajBiletu, double cena) {
        this.rodzajBiletu = rodzajBiletu;
        this.cena = cena;
    }

    public String toString(){
        return ("" + rodzajBiletu + " " + cena + "zl");
    }

    public void setCena(double x){
        cena = x;
    }
    public double getCena(){
        return cena;
    }

    public void setRodzaj(String r){
        rodzajBiletu = r;
    }

    public String getRodzaj(){
        return rodzajBiletu;
    }
}
