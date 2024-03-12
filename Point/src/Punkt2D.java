public class Punkt2D extends Punkt {
    private int y;

    public Punkt2D(){
        super(0);
        this.y = 0;
    }
    public Punkt2D(int x, int y){
        super(x);
        this.y = y;
    }

    public void setX(int x){
        super.setX(x);
    }
    public int getX(){
        return super.getX();
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return this.y;
    }

    public int[] getWspolrzedne(){
        return new int[]{super.getX(),y};
    }

    @Override
    public String toString(){
        return ("(" + super.getX() + "," + y + ")");
    }
}
