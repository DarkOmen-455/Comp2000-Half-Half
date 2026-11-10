import java.awt.Graphics2D;
import java.awt.Color;

public class GroceryShopDecorator extends ShopDecorator {

//constructor   
public GroceryShopDecorator(Shop shop){
    super(shop);
    }

//gets the shops name    
@Override
public String getName() { 
    return getDecoratedShop().getName() + " - Grocery Shop ";
    }

// description of what the shop sells 
@Override
public String getDescription() {
    return " a small shop to buy, fruit, meat and household supplies. ";
}

// returns capacity of customers 
@Override
public int getShopCapacity() { 
    return 120; 
}

// draws a white square to represent a grocery store
@Override
public void build(Graphics2D g2d, int x, int y){ 
    g2d.setColor(Color.WHITE);
    g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
}
}


