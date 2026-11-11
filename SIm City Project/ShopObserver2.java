public class ShopObserver2 implements GridObserver {
    private final Window window;
    private boolean placingShop;
    private PopulationObserver2 pop;

    public ShopObserver2(Window window, PopulationObserver2 pop) {
        this.window = window;
        this.pop = pop;
    }

    @Override
    public void receive(int x, int y, Building oldBuilding, Building newBuilding) {
    //  this observer placing a shop.
        if (placingShop) {
            return;
        }

        int shopsRequired = Shop.shopsRequired(pop.getPopulation2());
        
        while (window.getShopCount() < shopsRequired) {
            int[] location = window.findFreeLocation();

            // There is nowhere to place another shop.
            if (location == null) {
                return;
            }

            placingShop = true;
            try {
                window.place(location[0], location[1], new Shop());
            } finally {
                placingShop = false;
            }
        }
    }
}