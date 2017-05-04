package data;

import java.util.*;

public class WeatherData_West implements Subject, WeatherData {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData_West() {
		this.observers = new ArrayList<Observer>();
		this.pressure= InitProperties.INIT_PRESSURE;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	//call the observers update method
	public void notifyObservers() {
		for(Observer o: observers){
			o.update(temperature, humidity, pressure);
		}

	}

	@Override
	//record the new data and notifyObservers()
	public void dataIn(float temperature, float humidity, float pressure) {
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		notifyObservers();
	}

	@Override
	public float getTemperature() {
		return temperature;
	}

	@Override
	public float getHumidity() {
		return humidity;
	}

	@Override
	public float getPressure() {
		return pressure;
	}

}
