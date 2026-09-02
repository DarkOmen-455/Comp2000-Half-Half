
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initializing program");
        Window w = new Window(800, 600); // width then height

        House test = new House(3, 3);
        w.place(5, 5, test);

        Apartment test2 = new Apartment();
        w.place (6,6,test2);

        Office test3 = new Office(7);
        

        for (int i = 0; i < 10; i++) {
            int randomX = (int)(Math.random() * 10);
            int randomY = (int)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(1);
            w.place(randomX,randomY, test3);
        }
    }
}
