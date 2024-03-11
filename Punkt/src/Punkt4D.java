public class Punkt4D extends Punkt3D {
    private int t;

    public Punkt4D(){
        super(0,0,0);
        this.t = 0;
    }
    public Punkt4D(int x, int y, int z, int t){
        super(x,y,z);
        this.t = t;
    }
    public Punkt4D(Punkt3D p, int t){
        super(p.getX(),p.getY(),p.getZ());
        this.t = t;
    }

    public void setT(int t){
        this.t = t;
    }
    public int getT(){
        return this.t;
    }
    @Override
    public int[] getWspolrzedne(){
        return new int[]{super.getX(),super.getY(),super.getZ(),t};
    }
    @Override
    public String toString(){
        return ("(" + super.getX() + "," + super.getY() + "," + super.getZ() + "," + t + ")");
    }
}

