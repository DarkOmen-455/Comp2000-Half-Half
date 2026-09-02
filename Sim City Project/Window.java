import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Window extends Frame {

    private int width;
    private int height;
    private Building[][] grid;

     public int totalPeople(){
        int total = 0;
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
        this.grid = new Building[10][14];
        this.setVisible(true);
        this.setSize(width,height);
        this.setTitle("Sim City");
        this.setBackground(Color.green);
        Building[][] grid = new Building[10][10];

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public boolean toBuildSchool(){
        boolean total = false;
        int children = 0;
        for (int i = 0; i<grid.length; i++){
            for (int z = 0; z<grid[i].length; z++){
                if (grid[z][i] instanceof House){
                    total += grid[z][i].getChildren();
                    continue;
                }
                if (grid[z][z] instanceof Apartment){
                    total += grid[z][i].get();
                    continue;
                }
            }
        }
        return total;
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
        if (x >= 1 && x < grid.length && y >= 1 && y < grid[x].length) {// inside grid
            grid[x][y] = b;
            repaint();
        }
    }

    
}
