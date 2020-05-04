package mainPackage;

import java.util.ArrayList;

import observerPackage.Observable;
import observerPackage.Observer;

public class Trainee implements Observable {	//Contains both command and observer methods.

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String name;
	private Boolean lying;
	private String[] states={"standing up!","lying down!"};	//Easier to set for observers.
	private String state;									//Possibly also useful for commands.
	
	public Trainee(String name) {
		this.name=name;
	}

	public void setDefaultStanding(Boolean standing) {
		this.lying=!standing;	//If standing is true, lying is false. If standing is false, lying is true.
		state=states[0];
	}
	
	public void lieDownCommand() {
		if(lying==false) {
			System.out.println("Trainee "+name+": Lying down!");
			this.lying = true;
			state=states[1];
			this.notifyObservers();
		}
		else {
			System.out.println("Trainee "+name+": Already lying down!");
		}
	}
	public void standUpCommand() {
		if(lying==true) {
			System.out.println("Trainee "+name+": Standing up!");
			this.lying = false;
			state=states[0];
			this.notifyObservers();
		}
		else {
			System.out.println("Trainee "+name+": Already standing!");
		}
	}
	
	public void setName(String name) {
		this.name = name;
		this.notifyObservers();
	}

	@Override
	public void register(Observer observer) {
		this.observers.add(observer);
		observer.setTrainee(this);
		
	}

	@Override
	public void unregister(Observer observer) {
		this.observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: this.observers) {
			observer.update();
		}		
	}

	@Override
	public String getUpdate() {
		return this.state;	
	}
	
}
