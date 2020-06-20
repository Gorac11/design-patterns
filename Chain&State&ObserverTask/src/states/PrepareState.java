package states;

import chain.Desk;

public class PrepareState implements State {


	private String stateName = "PREPARE_STATE";
	
	@Override
	public void applyState(Desk desk) {
		desk.setState(this);
	}
	
	public String getStateName() {
		return this.stateName;
	}

}
