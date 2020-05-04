package commandPackage;

import mainPackage.Trainee;

public class LieDownCommand implements Command {

	private Trainee trainee;
	
	public LieDownCommand(Trainee trainee) {
		this.trainee=trainee;
	}
	
	@Override
	public void execute() {
		this.trainee.lieDownCommand();
	}

}
