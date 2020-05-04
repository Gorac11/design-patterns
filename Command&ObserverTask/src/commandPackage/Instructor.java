package commandPackage;

public class Instructor {

	private Command command;
	private String name;
	
	public Instructor(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setCommand(Command command) {
		this.command = command;
		this.command.execute();
	}

}
