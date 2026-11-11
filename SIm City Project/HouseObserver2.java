import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class HouseObserver2{
    private final Window window;
    private final long interval = 1500;
    private final RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
    private boolean placingHouse = false;
    private long lastUpTime;


    public HouseObserver2(Window window) {
        this.window = window;
    }

    public void receive(){
        if (placingHouse) {
            return;
        }

        long upTime = runtimeBean.getUptime(); // returns uptime in milliseconds

        if (lastUpTime != 0 && upTime - lastUpTime < interval) {
            return;
        }

        int[] location = window.findFreeLocation();
        if (location == null) {
            return;
        }

        placingHouse = true;
        try {
            window.place(location[0], location[1], new House(2, 2));
            lastUpTime = upTime;
        } finally {
            placingHouse = false;
        }
    }

}