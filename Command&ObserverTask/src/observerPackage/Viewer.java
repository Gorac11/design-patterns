package observerPackage;

public class Viewer implements Observer {

	private String name;
	private Observable trainee;
	private String traineeState;
	
	public Viewer(String name) {
		this.setName(name);
	}
	
	private void setName(String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void update() {
		
		//Is there a need for an if(?==null){SystemOut...;return;} ???
		
		traineeState = trainee.getUpdate();
		System.out.println(this.getName() + " is " + traineeState);
	}

	@Override
	public void setTrainee(Observable trainee) {
		this.trainee = trainee;

	}

}
