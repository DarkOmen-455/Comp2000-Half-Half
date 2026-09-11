import java.awt.Graphics2D;
import java.util.ArrayList;
class Building{
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
        return 0;
    }

    public boolean toBeBuilt(){
        return false;
    }

    public  void build(Graphics2D g2d, int x, int y){}

    public String getName(){
        return getClass().getSimpleName();
    }

    public <T extends Building> void addBuilding(ArrayList<T> buildings, T building) {
        buildings.add(building);
    }
}