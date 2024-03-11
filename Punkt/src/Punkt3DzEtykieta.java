public class Punkt3DzEtykieta extends Punkt3D{
    String etykieta;

    public Punkt3DzEtykieta(){
        super(0,0,0);
        this.etykieta = "NULL";
    }
    public Punkt3DzEtykieta(int x, int y, int z, String etykieta){
        super(x,y,z);
        this.etykieta = etykieta;
    }
    public Punkt3DzEtykieta(Punkt3D p, String etykieta){
        super(p.getX(),p.getY(),p.getZ());
        this.etykieta = etykieta;
    }

    public void setEtykieta(String etykieta){
        this.etykieta = etykieta;
    }
    public String getEtykieta(){
        return this.etykieta;
    }
    @Override
    public int[] getWspolrzedne(){
        return new int[]{super.getX(),super.getY(),super.getZ()};
    }
    @Override
    public String toString(){
        return ("(" + super.getX() + "," + super.getY() + "," + super.getZ() + ") " + etykieta);
    }
}
