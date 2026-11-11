package WeatherStates;
import java.awt.Graphics2D;
import java.awt.Color;
public class Sunny implements WeatherState {

    @Override
    public void action(Weather context) {
        this.weather()
        context.setState(this);
    }

    private void weather(Graphics2D g2d){
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(50, 50, 35, 35);
    }
}

