package commandPackage;

public class Instructor {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
		this.command.execute();
	}

}
