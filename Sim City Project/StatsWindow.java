import java.awt.*;
import javax.swing.JLabel;

public class StatsWindow extends Frame {
    JLabel label = new JLabel("Label");
    
    StatsWindow(int width, int height){
        this.setTitle("Stats Window");
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocation(1920/2, 1080/2);

       this.add(label);
       label.setVisible(true);

        
    }

    public void updateLabel(String text){
        label.setText("population: " + text);
         
    }
}
