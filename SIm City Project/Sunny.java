

import java.awt.Graphics2D;
import java.awt.Color;
public class Sunny implements WeatherState {

    @Override
    public void action(Weather context, Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(-40, 0, 35, 35);        
        context.setState(this);
    }


}
