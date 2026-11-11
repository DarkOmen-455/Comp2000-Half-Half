import java.awt.Graphics2D;
import java.awt.Color;

public class CafeShopDecorator extends ShopDecorator {

//constructor   
public CafeShopDecorator(Shop shop){
    super(shop);
    }

//gets the shops name    
@Override
public String getName() { 
    return getDecoratedShop().getName() + " - Cafe Shop ";
    }

// description of what the shop sells 
@Override
public String getDescription() {
    return " a small shop to buy drinks and sweets. ";
}

// returns capacity of customers 
@Override
public int getShopCapacity() { 
    return 50; 
}

//draws a pink square to present Cafe
@Override
public void build(Graphics2D g2d, int x, int y){ 
    g2d.setColor(Color.PINK);
    g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
}
}


