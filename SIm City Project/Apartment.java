import java.awt.Color;
import java.awt.Graphics2D;
public class Apartment extends Building {
    private final int population;

    public Apartment() {
        this(0);
    }

    public Apartment(int population) {
        this.population = population;
    }

    @Override
    public int getPopulation() {
        return population;
    }

    @Override
    public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
    }

    @Override 
    public String getName(){
        return getClass().getSimpleName();
    } 

    
}