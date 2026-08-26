
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class app{
    public static void main(String[] args) {
        System.out.println("Initializing program");

        //Initialising the Main Window
        Frame frame = new Frame("Sim City");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setBackground(Color.green);

        //Method to allow window closing
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }

        });
    }

}