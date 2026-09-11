import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
public class Window extends Frame {

    private int width;
    private int height;
    private Building[][] grid;

    public int[] getGridSize(){
        int x = 0;
        return new int[]{grid.length, grid[x].length};
    }

     public int totalPeople(){
        int total = 0;
        for (int x = 0; x<grid.length; x++){
            for (int y = 0; y<grid[x].length; y++){
                if (grid[x][y] == null)
                    continue;
                if (grid[x][y].getName().equals("Apartment") || grid[x][y].getName().equals( "House")){
                    total += grid[x][y].getPopulation();
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
        }
    }

    Window(int width, int height){
        this.width = width;
        this.height = height;
        this.setSize(width,height);
        this.grid = new Building[(width - 100) / 50][(height - 100) / 50];
        this.setTitle("Sim City");
        this.setBackground(Color.green);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public int getBuilding(String temp){
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

    @Override public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 100; i++) {
            g2d.drawLine(i * 50, 50, i * 50, 550);
        }

        for (int i = 0; i < 100; i++) {
           g2d.drawLine(50, i*50, 750, i*50);
        }

        g2d.translate(50, 50);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] != null) {
                    grid[x][y].build(g2d, x, y);
                }
            }
        }
    }

    public void drawRedOval(Graphics2D ovalg2d, int x, int y){
        ovalg2d.setColor(Color.RED);
        ovalg2d.fillOval((x*50)+7,(y*50)+7,35,35);
    }

    public void remove(int x, int y){
        grid[x][y] = null;
        repaint();
    }

    public void place(int x, int y, Building b){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
                grid[x][y] = b;
                repaint();
        }
    }

    public int[] findFreeLocation(){
        int centerX = grid.length / 2;
        int centerY = grid[0].length / 2;

        int ram = (int)(Math.random() * 4) + 1;
        int maxRadius = Math.max(centerX, centerY);
        int minX;
        int maxX;
        int minY;
        int maxY;

        switch (ram) {
            case 1:
                minX = centerX;
                maxX = grid.length - 1;
                minY = 0;
                maxY = centerY;
                break;
            case 2:
                minX = 0;
                maxX = centerX;
                minY = 0;
                maxY = centerY;
                break;
            case 3:
                minX = 0;
                maxX = centerX;
                minY = centerY;
                maxY = grid[0].length - 1;
                break;
            case 4:
                minX = centerX;
                maxX = grid.length - 1;
                minY = centerY;
                maxY = grid[0].length - 1;
                break;
            default:
                return null;
        }

        for (int radius = 0; radius <= maxRadius; radius++) {
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    if (Math.abs(x - centerX) <= radius && Math.abs(y - centerY) <= radius && spare(x, y)) {
                        return new int[]{x, y};
                    }
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

    public void incPopulation(){
        int step = 5;
        ArrayList<House> total = new ArrayList<House>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] instanceof House){
                    total.add((House) grid[x][y]);
                }
            }
        }
        for (int i = 0; i<step;i++){
            try{
                int index = (int)(Math.random() * total.size());
                if (total.get(index).getAdults() <= 6){
                    total.get(index).setAdults(total.get(index).getAdults()+1);
                }
                else{
                    total.get(index).setAdults(total.get(index).getAdults()-1);
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("ArrayList out of bounds at:"+i);
            }
        }
    }

    public int getShopCount() {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for( int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] instanceof Shop) {
                    count++;
                }
            }
        }
        return count;
    }

    public void tick(){
        incPopulation();
        int population = totalPeople();

        int shopsNeeded = Shop.shopsRequired(population);
        int shopsExisting = getShopCount();
        if (shopsExisting < shopsNeeded){
            int[] freeSpot = findFreeLocation();
            if (freeSpot != null){
                place(freeSpot[0], freeSpot[1], new Shop());
            }
        }
        tryBuildMall(population);
    }

public void houseMain(){
    House house = new House(2,2);
    int[] locaition = findFreeLocation();
    place(locaition[0], locaition[1], house);

    int population = totalPeople();
    System.out.println("total population: "+ population);

    int shopsNeeded = Shop.shopsRequired(population);
    int shopsExisting = getShopCount();
    if (shopsExisting < shopsNeeded){
        int[] freeSpot = findFreeLocation();
        if (freeSpot != null){
            place(freeSpot[0], freeSpot[1], new Shop());
        }
    }

    tryBuildMall(population);
}


    public boolean tryBuildMall(int cityPopulation){
        ArrayList<int[]> shopLocations = new ArrayList<>();
        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y < grid[x].length; y++){
                if (grid[x][y] instanceof Shop){
                    shopLocations.add(new int[]{x, y});
                }
            }
        }

        if (!Mall.canBuild(shopLocations.size(), cityPopulation)){
            return false;
        }

        if (Math.random() > 0.08){
            return false;
        }

        Mall mall = new Mall();

        for (int i = 0; i < mall.list.length; i++){
            int[] loc = shopLocations.get(i);
            mall.list[i] = (Shop) grid[loc[0]][loc[1]];
            grid[loc[0]][loc[1]] = null;
        }

        int[] mallLocation = shopLocations.get(0);
        place(mallLocation[0], mallLocation[1], mall);
        return true;
    }
}