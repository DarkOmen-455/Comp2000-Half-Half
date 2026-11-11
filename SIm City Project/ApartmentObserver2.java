public class ApartmentObserver2 implements GridObserver {
    private boolean placingApartment;
    private final Window window;

    public ApartmentObserver2(Window window) {
        this.window = window;
    }

    @Override
    public void receive(int x, int y, Building oldBuilding, Building newBuilding) {
        if (placingApartment || !(newBuilding instanceof House)) {
            return;
        }

        int[] gridSize = window.getGridSize();
        for (int topLeftX = Math.max(0, x - 1); topLeftX <= x; topLeftX++) {
            for (int topLeftY = Math.max(0, y - 1); topLeftY <= y; topLeftY++) {
                if (topLeftX + 1 >= gridSize[0] || topLeftY + 1 >= gridSize[1]) {
                    continue;
                }

                Building topLeft = window.getIndex(topLeftX, topLeftY);
                Building topRight = window.getIndex(topLeftX + 1, topLeftY);
                Building bottomLeft = window.getIndex(topLeftX, topLeftY + 1);
                Building bottomRight = window.getIndex(topLeftX + 1, topLeftY + 1);

                if (!(topLeft instanceof House) || !(topRight instanceof House)   || !(bottomLeft instanceof House)        || !(bottomRight instanceof House)) {
                    continue;
                }

                int combinedPopulation = topLeft.getPopulation()+ topRight.getPopulation()   + bottomLeft.getPopulation() + bottomRight.getPopulation();

                placingApartment = true;
                try {
                    window.remove(topLeftX + 1, topLeftY);
                    window.remove(topLeftX, topLeftY + 1);
                    window.remove(topLeftX + 1, topLeftY + 1);
                    window.place(topLeftX, topLeftY, new Apartment(combinedPopulation));
                } finally {
                    placingApartment = false;
                }
                return;
            }
        }
    }
}
