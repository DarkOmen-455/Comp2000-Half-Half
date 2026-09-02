import java.awt.*;
public class Office extends Apartment{
    private int workers; 

    public Office(int x){
        workers = x;
    }



    public int getPopulation(){
        return workers;
    }


    @Override
    public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLUE);
        g2d.fillOval((x * 50) + 7, (y * 50) + 7, 35, 35);
    }
}