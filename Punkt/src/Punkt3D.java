public class Punkt3D extends Punkt2D{
    private int z;

    public Punkt3D(){
        super(0,0);
        this.z = 0;
    }
    public Punkt3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }
    public Punkt3D(Punkt2D p, int z){
        super(p.getX(),p.getY());
        this.z = z;
    }

    public void setZ(int z){
        this.z = z;
    }
    public int getZ(){
        return this.z;
    }
    @Override
    public int[] getWspolrzedne(){
        return new int[]{super.getX(),super.getY(),z};
    }
    @Override
    public String toString(){
        return ("(" + super.getX() + "," + super.getY() + "," + z + ")");
    }

}