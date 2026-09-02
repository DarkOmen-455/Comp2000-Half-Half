import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initializing program");
        Window w = new Window(800, 600); // width then height

        // House test = new House(3, 3);
        // for (int i = 0; i < 10; i++) {
        //     int randomX = (int)(Math.random() * 9);
        //     int randomY = (int)(Math.random() * 9);
        //     TimeUnit.SECONDS.sleep(1);
        //     w.place(randomX, randomY, test);
        // }
        

        Apartment test2 = new Apartment();
        w.place (6,6,test2);

         var random = new Random();
        // int minX = 1;
         int minY = 1;
        // int maxX = 
        int maxY = 10;
        //     int randomX = 2 + (int)(Math.random() * ((14 - 2)) + 1);
           int randomY = random.nextInt(maxY - minY + 1) + minY;

        //     System.out.println(randomX);
             System.out.println(randomY);
    
        Office test3 = new Office(0, 0);
        w.place(9, randomY, test3);
    }
}
