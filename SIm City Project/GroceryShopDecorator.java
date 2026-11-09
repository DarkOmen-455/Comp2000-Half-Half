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
    return getDecoratedShop().getDescription() + " a small shop to buy, fruit, meat and household supplies. ";
}
}

