package WeatherStates;
public class Weather{
    private WeatherState currentState; 

    public WeatherState getState(){
        return currentState;
    }
    
    public Weather(){
        currentState = new Sunny();
    }

    public void setState(WeatherState state){
        this.currentState = state;
    }

    public void changeWeather(){
        currentState.action(this);
    }
}