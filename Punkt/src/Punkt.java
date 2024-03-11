public class Punkt {
    private int x;

    public Punkt(){
        this.x = 0;
    }
    public Punkt(int x){
        this.x = x;
    }

    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }

    public String toString(){
        return ("(" + x + ")");
    }

}
