


import java.awt.Graphics2D;

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

    public void changeWeather(Graphics2D g2d){
        currentState.action(this, g2d);
    }
}