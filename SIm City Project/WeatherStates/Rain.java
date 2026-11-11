package WeatherStates;
public class Rain implements WeatherState{
        
    @Override
    public void action(Weather context) {
        context.setState(this);
    } 
}
