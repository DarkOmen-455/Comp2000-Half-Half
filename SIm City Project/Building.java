import java.awt.Graphics2D;
abstract class Building {
    private int x, y;

    public void setX(int X){
        this.x = X;
    }

    public void setY(int Y){
        this.y = Y;
    }

    public int getX(){
        return x;
    } 

    public int getY(){
        return y;
    }

    public int getPopulation(){
        return -1;
    }

    public boolean toBeBuilt(){
        return false;
    }

    public abstract void build(Graphics2D g2d, int x, int y);
    
}