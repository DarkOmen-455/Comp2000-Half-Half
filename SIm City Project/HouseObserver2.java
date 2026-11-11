import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class HouseObserver2{
    private final Window window;
    long interval = 1500;
    RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
    boolean placingHouse = false;
    long lastUpTime = 0; 


    public HouseObserver2(Window window) {
        this.window = window;
    }

    public void receive(){
        if (placingHouse)
            return; 
        
        long upTime = runtimeBean.getUptime(); // returns uptime in milliseconds

        if ((upTime - lastUpTime)>1500){
            placingHouse = true;
            int[] location = window.findFreeLocation();
            try{
                window.place(location[0], location[1], new House(2,2));
            } finally{
                placingHouse = false;
            }
        }
    }

}