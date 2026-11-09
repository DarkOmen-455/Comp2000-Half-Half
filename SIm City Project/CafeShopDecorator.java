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
    return getDecoratedShop().getDescription() + " a small shop to buy drinks and sweets. ";
}
}


