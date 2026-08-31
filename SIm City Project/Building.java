import java.util.ArrayList;
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

    public abstract void build(int x, int y);
    
    public abstract void destroy(int x, int y);
}