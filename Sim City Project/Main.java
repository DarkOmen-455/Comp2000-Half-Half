import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initializing program");
        Window w = new Window(800, 600);
        StatsWindow sw = new StatsWindow(300, 300);

        // seed a few starting houses
        for (int i = 0; i < 15; i++) {
            int[] location = w.findFreeLocation();
            if (location == null) break;
            w.place(location[0], location[1], new House(0, 0));
        }

        // run the simulation loop
        for (int i = 0; i < 200; i++) {
            w.tick();
            sw.updateLabel(Integer.toString(w.total));
            sw.updateShopLabel(Integer.toString(w.getShopCount()));
            Thread.sleep(200);
        }
    }
}