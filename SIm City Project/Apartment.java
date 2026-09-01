import java.awt.Graphics2D;
import java.awt.Color;
public class Apartment extends Building{
    
    @Override
    public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
    }
}