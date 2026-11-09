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
}
