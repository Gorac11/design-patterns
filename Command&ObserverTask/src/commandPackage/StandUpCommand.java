package commandPackage;

import mainPackage.Trainee;

public class StandUpCommand implements Command {
	
	private Trainee trainee;
	
	public StandUpCommand(Trainee trainee) {
		this.trainee=trainee;
	}
	
	@Override
	public void execute() {
		this.trainee.standUpCommand();
	}

}
