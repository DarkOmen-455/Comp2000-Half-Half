import java.awt.Graphics2D;
import java.awt.Color;
public class House extends Building{
    private int children, adults;
    
    public House(int x, int y){
        this.children = 2;
        this.adults = 2;
    }

    //red circle represents house
    @Override
    public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(Color.RED);
        g2d.fillOval((x * 50) + 7, (y * 50) + 7, 35, 35);
    }

    @Override
    public void destroy(int x, int y) {
        // no special effect needed for now
    }

}
