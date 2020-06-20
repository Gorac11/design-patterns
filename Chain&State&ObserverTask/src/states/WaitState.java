package states;

import chain.Desk;

public class WaitState implements State {

	private String stateName = "WAIT_STATE";
	
	@Override
	public void applyState(Desk desk) {
		desk.setState(this);
	}
	
	public String getStateName() {
		return this.stateName;
	}
}
