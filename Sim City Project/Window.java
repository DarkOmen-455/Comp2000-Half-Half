import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Window extends Frame {

    private int width;
    private int height;
    private Building[][] grid;
    public int total = 0;

     public int totalPeople(){
        for (int i = 0; i<grid.length; i++){
            for (int z = 0; z<grid[i].length; z++){
                if (grid[z][i] instanceof House){
                    total += grid[z][i].getPopulation();
                    continue;
                }
                if (grid[z][z] instanceof Apartment){
                    total += grid[z][i].getPopulation();
                    continue;
                }
                    
            }
        }
        System.out.println("total people = "+total);
        return total;
    }

    public void reset(){
        if (totalPeople() >=2000){
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    grid[x][y] = null;
                }
            }

            // place new house to start idk with users mouse?
        }
        
    }


    // constructor, acts as a decorator for our main window
    Window(int width, int height){
        this.width = width;
        this.height = height;
        this.grid = new Building[15][15];
        this.setVisible(true);
        this.setSize(width,height);
        this.setTitle("Sim City");
        this.setBackground(Color.green);
        Building[][] grid = new Building[height/50][width/50];

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public int getBuilding(String temp){
        //pass in building subclass, returns number of subclasses in grid
        int total = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == null)
                    continue; 
                if (grid[x][y].getName() == temp){
                    total++;
                }
            }
        }
        return total;
    }


    // public boolean toBuildSchool(){
    //     boolean total = false;
    //     int children = 0;
    //     for (int i = 0; i<grid.length; i++){
    //         for (int z = 0; z<grid[i].length; z++){
    //             if (grid[z][i] instanceof House){
    //                 total += grid[z][i].getChildren();
    //                 continue;
    //             }
    //             if (grid[z][z] instanceof Apartment){
    //                 total += grid[z][i].get();
    //                 continue;
    //             }
    //         }
    //     }
    //     return total;
    // }
 

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

        //testing 
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] != null) {
                    grid[x][y].build(g2d, x, y);
                }
            }
        }
    }
    
    public void drawRedOval(Graphics2D ovalg2d, int x, int y){;// draws red oval
        ovalg2d.setColor(Color.RED);
        //ovalg2d.drawOval(75,75,25,25);
        ovalg2d.fillOval((x*50)+7,(y*50)+7,35,35);
    }
    
    public void remove(int x, int y){ 
        grid[x][y] = null;
        repaint();
    }

    public void place(int x, int y, Building b){

        //System.out.println(grid.length);
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
            grid[x][y] = b;
            repaint();
        }
    }

    public int[] findPlaceLocation(){
        // find square 
        int startX = height/50;
        int startY = width/50;

        //random 1-4, gives us sector of grid, havent impletmented
        int ram = 1; 

        //
        int x = startX -1; 
        int y = startY -1; 
        int[] total = new int[1];
        boolean even = false;  // so i dont have to repreaste code 
        while (startX < width/50 || startY < height/50){
            //check if in bottom left or right will implerment for top as well later
            // to move x and y to next diagional square 
            /*
            0 0 0 0 0        c = centerx and center y
            0 0 0 0 0
            - - c 0 0
            0 c | 0 0
            c 0 | 0 0
            */
            if (ram/2 == 0){
                startX++;
                startY--;
                even = true;
            }
            else {
                startX--;
                startY++;
            }
            x = startX; y = startY;// to reset x and y
            while(x<=(width/50)/2){// while x is not toching invissable center line 
                if (spare(startX,startY)){
                    total[0] = x;
                    total[1] = y;
                    return total;
                }
                if (even)
                    x--;
                else{
                    x++;
                }
            }
            while(y<=(height/50)/2){// same but for y
                if (spare(startX,startY)){
                    total[0] = x;
                    total[1] = y;
                    return total;
                }
                if(even)
                    y++;
                else{
                    y--;
                }
            }
        }
        return null;
    }
    public boolean spare(int x, int y){
        if (grid[x][y] == null){
            return true;
        }
        return false;
    }
}
