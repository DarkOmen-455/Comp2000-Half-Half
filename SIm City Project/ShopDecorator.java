import java.awt.Graphics2D;

public abstract class ShopDecorator extends Shop{
    

    private Shop decoratedShop;

    //constructor
    public ShopDecorator(Shop shop) {
        decoratedShop = shop;
    }

    // getter 
    public Shop getDecoratedShop() { 
        return decoratedShop; 
    }

    // returns the decoratedShops population
    @Override 
    public int getPopulation() {
        return decoratedShop.getPopulation();
    }

    // allows shops to be built
    @Override 
    public void build(Graphics2D g2d, int x, int y) {
        decoratedShop.build(g2d, x, y);
    }

    // returns shops name
    @Override 
    public String getName() {
        return decoratedShop.getName();
    }

    //checks if the shop can be built     
    @Override 
    public boolean toBeBuilt() { 
        return decoratedShop.toBeBuilt();
    }
}

