public class House extends Building{
    private int children, adults;
    
    public House(int x, int y){
        this.children = 2;
        this.adults = 2;
    }

    //red circle represents house
    public void build(int x, int y){

        
    }
    @Override public void paint(Graphics2D g2d){
        g2d.drawRedOval(x,y);       
    }
}
