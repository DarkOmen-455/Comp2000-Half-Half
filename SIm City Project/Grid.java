
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.Rectangle;
import javax.swing.JFrame;

//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Grid extends JFrame{
    static JFrame frame;


    public static void main(String[] args) {
        frame = new JFrame("Sim City");

        System.out.println("Initializing program");
        frame.setSize(600, 600);
        Rectangle bounds = frame.getBounds();
        frame.setLocation(500 + bounds.x, 10 + bounds.y); //set location of frame x and y plus offset 
        frame.setVisible(true);

        //Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Double(100, 100, 200,200);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }

        });
    }

}