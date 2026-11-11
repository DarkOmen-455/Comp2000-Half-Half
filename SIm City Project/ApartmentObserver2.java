import java.util.stream.IntStream;

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

        // i = 0..3 stands for the 4 possible top-left corners:
        // (x-1,y-1), (x-1,y), (x,y-1), (x,y)
        IntStream.range(0, 4)
                .filter(i -> isHouseBlock(x - 1 + i / 2, y - 1 + i % 2, gridSize))
                .findFirst()
                .ifPresent(i -> mergeIntoApartment(x - 1 + i / 2, y - 1 + i % 2));
    }

    // true if the 2x2 block starting at (tx, ty) fits in the grid and is all houses
    private boolean isHouseBlock(int tx, int ty, int[] gridSize) {
        if (tx < 0 || ty < 0 || tx + 1 >= gridSize[0] || ty + 1 >= gridSize[1]) {
            return false;
        }
        return window.getIndex(tx, ty) instanceof House
                && window.getIndex(tx + 1, ty) instanceof House
                && window.getIndex(tx, ty + 1) instanceof House
                && window.getIndex(tx + 1, ty + 1) instanceof House;
    }

    private void mergeIntoApartment(int tx, int ty) {
        int combinedPopulation = window.getIndex(tx, ty).getPopulation()
                + window.getIndex(tx + 1, ty).getPopulation()
                + window.getIndex(tx, ty + 1).getPopulation()
                + window.getIndex(tx + 1, ty + 1).getPopulation();

        placingApartment = true;
        try {
            window.remove(tx + 1, ty);
            window.remove(tx, ty + 1);
            window.remove(tx + 1, ty + 1);
            window.place(tx, ty, new Apartment(combinedPopulation));
        } finally {
            placingApartment = false;
        }
    }

    // @Override
    // public void receive(int x, int y, Building oldBuilding, Building newBuilding) {
    //     if (placingApartment || !(newBuilding instanceof House)) {
    //         return;
    //     }

    //     int startX = x - 1;
    //     if (startX < 0) 
    //         startX = 0;

    //     int startY = y - 1;
    //     if (startY < 0) 
    //         startY = 0;
        

    //     int[] gridSize = window.getGridSize();
    //     for (int topLeftX = startX; topLeftX <= x; topLeftX++) {
    //         for (int topLeftY = startY; topLeftY <= y; topLeftY++) {
    //             if (topLeftX + 1 >= gridSize[0] || topLeftY + 1 >= gridSize[1]) {
    //                 continue;
    //             }

    //             Building topLeft = window.getIndex(topLeftX, topLeftY);
    //             Building topRight = window.getIndex(topLeftX + 1, topLeftY);
    //             Building bottomLeft = window.getIndex(topLeftX, topLeftY + 1);
    //             Building bottomRight = window.getIndex(topLeftX + 1, topLeftY + 1);

    //             if (!(topLeft instanceof House) || !(topRight instanceof House)   || !(bottomLeft instanceof House)        || !(bottomRight instanceof House)) {
    //                 continue;
    //             }

    //             int combinedPopulation = topLeft.getPopulation() + topRight.getPopulation() + bottomLeft.getPopulation() + bottomRight.getPopulation();

    //             placingApartment = true;
    //             try {
    //                 window.remove(topLeftX + 1, topLeftY);
    //                 window.remove(topLeftX, topLeftY + 1);
    //                 window.remove(topLeftX + 1, topLeftY + 1);
    //                 window.place(topLeftX, topLeftY, new Apartment(combinedPopulation));
    //             } finally {
    //                 placingApartment = false;
    //             }
    //             return;
    //         }
    //     }
    // }
}
