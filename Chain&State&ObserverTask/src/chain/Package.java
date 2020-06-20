package chain;

import states.PrepareState;
import states.WaitState;

public class Package {
	
	WaitState waitState = new WaitState();
	PrepareState prepareState = new PrepareState();

	
public void send(int level, String message) {
	
	}

	protected void writeMessage(String message) {
		
	}
	
}
