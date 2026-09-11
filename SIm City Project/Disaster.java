public interface Disaster {
    public void 
    
} 

// class BabyBoom implements Disaster{

// }

class Covid implements Disaster{
    //all houses get -2 pop
    private int x;
    private int y;
    private int dec; 

    public Covid(int dec){
        this.dec = dec;
    }

    public Covid(int dec, int x, int y){
        this.x = x;
        this.y = y;
        this.dec = dec;
    }
    
}

class Meteor extends Covid{
    // area is destoryed 
    public void meteorImpact(Window window){ 
        //find lcoation 
        int[] cords = window.getGridSize(); 
        int x = (int)((Math.random() * cords[0]-2) + 1)-2; 
        int y = (int)((Math.random() * cords[1]-2) + 1)-2;
        
        // remove 
        for (int ydes = 0; ydes<4;ydes++){
            int xtest = x;
            for (int xdes = 0; xdes<4; xdes++){
                window.remove(xtest, y);
                xtest++;
            }
            xtest = x;
            y+= 1;
        }
        
    }
}