package chain;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;
import states.State;

public abstract class Desk extends Package implements Observable{

	public static int FOREIGN = 1;
	public static int COUNTRY = 2;
	public static int CITY = 3;
	

	private List<Observer> observers = new ArrayList<Observer>();	
	
	public State state;
	
	protected int level;
	
	protected Desk nextDesk;
	
	public void setNext(Desk nextDesk) {
		this.nextDesk = nextDesk;
	}
	@Override
	public void send(int level, String message) {
		
		if(this.level == level) {
			this.setState(prepareState);
		
			this.writeMessage(message);
			System.out.println(this.getDeskName()+" is in: "+this.getState());
			this.notifyObservers();

			this.setState(waitState);
			System.out.println(this.getDeskName()+" is in: "+this.getState()+"\n");
		}
		
		if(this.nextDesk != null) {
			this.nextDesk.send(level, message);
		}
	}
	
	public String getState() {
		return state.getStateName();
	}
	public void setState(State state) {
		this.state = state;	
	}
	
	@Override
	public void subscribe(Observer observer) {
		this.observers.add(observer);
		observer.setDesk(this);
	}

	@Override
	public void unsubscribe(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: this.observers) {
			observer.update();
		}
	}

	@Override
	public String getUpdateState() {
		return this.getState();
	}
	@Override
	public String getDeskName() {
		return this.getClass().getSimpleName();
	}

	
	
	
	
	
	
}
