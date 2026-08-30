import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Window extends Frame {

    // constructor, acts as a decorator for our main window
    Window(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setTitle("Sim City");
        this.setBackground(Color.green);

   this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }

        });

    }

    // paint method used to add graphics to the screen
    @Override public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(400, 0, 400, 600); //vertical line
        g2d.drawLine(0, 300, 800, 300); // horizontal line
        //to do, add grid logic
    }

    
}
