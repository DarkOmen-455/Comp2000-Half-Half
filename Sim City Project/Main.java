

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initializing program");
        Window w = new Window(800, 600); // width then height
        StatsWindow sw = new StatsWindow(300, 300);

        
        //  var random = new Random();
        //  int minX = 1;
        //  int minY = 1;
        //  int maxX = 14;
        //  int maxY = 10;


        // House test = new House(3, 3);
        // for (int i = 0; i < 10; i++) {
        //    int randomX = random.nextInt(maxX - minX + 1) + minX;
        //    int randomY = random.nextInt(maxY - minY + 1) + minY;
        //     TimeUnit.SECONDS.sleep(1);
        //     w.place(randomX, randomY, test);
        // }
        

        Apartment test2 = new Apartment();
        w.place (6,6,test2);
        w.remove(6,6);

        w.totalPeople();
        sw.updateLabel("wsg");
        sw.label.setVisible(true);
        


         
    
        Office test3 = new Office(0, 0);
        w.place(6, 7, test3);

        School test4 = new School();
        w.place (6,8,test4); 
    }
}
