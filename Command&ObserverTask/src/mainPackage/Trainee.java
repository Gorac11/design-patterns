package mainPackage;

import java.util.ArrayList;

import observerPackage.Observable;
import observerPackage.Observer;

public class Trainee implements Observable {	//Contains both command and observer methods.

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String name;
	private Boolean standing;	//Used in Ifs
	private String[] states={"standing up!","lying down!"};	//Easier to set for observers.
	private String currentState;							//Possibly also useful for commands.
	
	public Trainee(String name,Boolean standing) {
		this.name=name;
		this.standing=standing;
	}

	//Alternative way to set default position in Main method.
	public void setDefaultStanding(Boolean standing) {
		this.standing=standing;	
	}
	
	
	public void lieDownCommand() {
		if(standing==true) {
			System.out.println("Trainee "+name+": Lying down!");
			this.standing = false;
			currentState=states[1];
			this.notifyObservers();
		}
		else {
			System.out.println("Trainee "+name+": Already lying down!");
		}
	}
	public void standUpCommand() {
		if(standing==false) {
			System.out.println("Trainee "+name+": Standing up!");
			this.standing = true;
			currentState=states[0];
			this.notifyObservers();
		}
		else {
			System.out.println("Trainee "+name+": Already standing!");
		}
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
		return this.currentState;	
	}
	
}
