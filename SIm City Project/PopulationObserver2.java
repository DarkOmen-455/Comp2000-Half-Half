import java.util.ArrayList;

public class PopulationObserver2 implements GridObserver{
    int totalPop = 0;
    ArrayList<House> housingList = new ArrayList<>();

    public int getPopulation2(){
        return totalPop;
    }

    @Override 
    public void receive(int x, int y, Building oldBuilding, Building newBuilding){
        if (newBuilding == null) {
            if (oldBuilding != null) {
                totalPop -= oldBuilding.getPopulation();
            }
        } else if (oldBuilding == null) {
            totalPop += newBuilding.getPopulation();
        } else {
            totalPop += newBuilding.getPopulation();
            totalPop -= oldBuilding.getPopulation();
        }

        System.out.println("pop "+totalPop);
    }
}
