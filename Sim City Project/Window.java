import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Window extends Frame {

    
    int width; 
    int height;
    // constructor, acts as a decorator for our main window
    Window(int width, int height){
        this.setVisible(true);
        this.setSize(width,height);
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
        


        //loop for vertical lines
        for (int i = 0; i < 100; i++) {
            g2d.drawLine(i * 50, 50, i * 50, 550);    
        }

        //loop for horizontal line
        for (int i = 0; i < 100; i++) {
           g2d.drawLine(50, i*50, 750, i*50); 
        }

        //draw an oval
        Graphics2D ovalg2d = (Graphics2D) g;
        drawRedOval(ovalg2d,2,2);
        ///removeDrawing(ovalg2d, 2, 2);

    }
    
    public void drawRedOval(Graphics2D ovalg2d, int x, int y){;// draws red oval
        ovalg2d.setColor(Color.RED);
        //ovalg2d.drawOval(75,75,25,25);
        ovalg2d.fillOval((x*50)+7,(y*50)+7,35,35);
    }
    
    public void removeDrawing( int x, int y){// replaces current object with green reactacngle 
        Graphics2D ob = (Graphics2D) g;
        ob.setColor(Color.green);
        ob.fillRect((x*50)+1,(y*50)+1, 48,48);
    }

    
}
