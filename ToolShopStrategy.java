public class ToolShopStrategy implements  BuildLogic{
    
    @Override 
    public void build(Window w){

        Shop shop = new ToolShopDecorator(new Shop());

        int [] location = w.findFreeLocation();

        if(location != null){
            w.place(location[0], location[1], shop);
        
        System.out.println(shop.getName());
        System.out.println(shop.getDescription());
        System.out.println("Capacity: " + shop.getShopCapacity());
        }
     }
    }

