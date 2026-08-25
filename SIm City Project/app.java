
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class app{
    public static void main(String[] args) {
        System.out.println("Initializing program");

        Frame frame = new Frame("Sim City");
        frame.setSize(400, 200);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }

        });
    }

}