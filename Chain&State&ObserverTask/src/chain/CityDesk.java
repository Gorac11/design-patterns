package chain;

public class CityDesk extends Desk {
	public CityDesk() {
		this.level = Desk.CITY;
		this.setState(waitState);
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Package for Plovdiv: " + message);
	}

	
	

}
