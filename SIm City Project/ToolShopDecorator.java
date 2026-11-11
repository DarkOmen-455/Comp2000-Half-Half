import java.awt.Graphics2D;
import java.awt.Color;

public class ToolShopDecorator extends ShopDecorator {

//constructor   
public ToolShopDecorator(Shop shop){
    super(shop);
    }

//gets the shops name    
@Override
public String getName() { 
    return getDecoratedShop().getName() + " - Tool Shop ";
    }

// description of what the shop sells 
@Override
public String getDescription() {
    return " a small shop to buy tools, paint and machinery. ";
}

// returns capacity of customers 
@Override
public int getShopCapacity() { 
    return 25; 
}

//draws a cyan sqaure to represent toolShop
@Override
public void build(Graphics2D g2d, int x, int y){ 
    g2d.setColor(Color.CYAN);
    g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
}
}