import java.util.ArrayList;

public class EventManager<T extends CityEvent>{
    private ArrayList<T> list = new ArrayList<>();
    private int indexActive;

    public void add(T eventT){
        list.add(eventT);
    }

    public void runAll(Window window){
        for(int i = 0; i<list.size(); i++){
            list.get(i).run(window);
        }
    }

    public T nextEvent(){
        return list.get(indexActive+1);
    }
    
}