import java.awt.*;
public class Office extends Apartment{
    private int workers; 

    public Office(int x, int y){
        this.workers  = getWorkers();
    }


    public void setWorkers(int X){
        workers = X;
    }
    public int getWorkers(){
        return workers;
    }

    @Override
    public int getPopulation(){
        return workers;
    }


    @Override
    public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLUE);
        g2d.fillOval((x * 50) + 7, (y * 50) + 7, 35, 35);
    }
}