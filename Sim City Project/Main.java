import java.awt.Graphics2D;
public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing program");
        Window w = new Window(800, 600); // width then height

        House test = new House(3, 3);
        w.place(5, 5, test);

        Apartment test2 = new Apartment();
        w.place (6,6,test2);
    }
}
