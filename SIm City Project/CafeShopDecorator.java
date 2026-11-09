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
}
