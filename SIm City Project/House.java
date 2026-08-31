public class House extends Building{
    private int children, adults;
    
    public House(int x, int y){
        this.children = 2;
        this.adults = 2;
    }

    //red circle represents house
    public void build(int x, int y){

        drawRedOval(x,y);
    }
}
