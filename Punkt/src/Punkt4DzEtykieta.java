public class Punkt4DzEtykieta extends Punkt4D {
    private String etykieta;

    public Punkt4DzEtykieta(){
        super(0,0,0,0);
        this.etykieta = "NULL";
    }
    public Punkt4DzEtykieta(int x, int y, int z, int t, String etykieta){
        super(x,y,z,t);
        this.etykieta = etykieta;
    }
    public Punkt4DzEtykieta(Punkt4D p, String etykieta){
        super(p.getX(),p.getY(),p.getZ(),p.getT());
        this.etykieta = etykieta;
    }

    public void setEtylkieta(String etykieta){
        this.etykieta = etykieta;
    }
    public String getEtykieta(){
        return this.etykieta;
    }
    @Override
    public int[] getWspolrzedne(){
        return new int[]{super.getX(),super.getY(),super.getZ(),super.getT()};
    }
    @Override
    public String toString(){
        return ("(" + super.getX() + "," + super.getY() + "," + super.getZ() + "," + super.getT() + ") " + etykieta);
    }
}
