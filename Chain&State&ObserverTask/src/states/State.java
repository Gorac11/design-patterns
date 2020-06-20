package states;

import chain.Desk;

public interface State {
	public void applyState(Desk desk);
	public String getStateName();
}
