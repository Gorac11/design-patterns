package chain;

public class CountryDesk extends Desk {
	public CountryDesk() {
		this.level = Desk.COUNTRY;
		this.setState(waitState);
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Package for this country: " + message);
	}

	
}
