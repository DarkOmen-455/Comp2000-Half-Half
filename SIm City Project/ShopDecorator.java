import java.awt.Graphics2D;

public abstract class ShopDecorator extends Shop{
    

    private Shop decoratedShop;

    public ShopDecorator(Shop shop) {
        decoratedShop = shop;
    }

    public Shop getDecoratedShop() { 
        return decoratedShop; 
    }

    @Override 
    public int getPopulation() {
        return decoratedShop.getPopulation();
    }

    @Override 
    public void build(Graphics2D g2d, int x, int y) {
        decoratedShop.build(g2d, x, y);
    }

    @Override 
    public String getName() {
        return decoratedShop.getName();
    }

    @Override 
    public boolean toBeBuilt() { 
        return decoratedShop.toBeBuilt();
    }
}

