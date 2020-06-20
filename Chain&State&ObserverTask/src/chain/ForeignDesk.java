package chain;

public class ForeignDesk extends Desk {
	
	public ForeignDesk() {
		this.level = Desk.FOREIGN;
		this.setState(waitState);
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Package for foreign country: " + message);
	}

	


}
