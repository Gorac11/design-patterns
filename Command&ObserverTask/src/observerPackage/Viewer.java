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
		/*if(trainee == null) {
			System.out.println("No one is training.");	//Would this be actually useful at all? Never used.
			return;
		}*/
		traineeState = trainee.getUpdate();
		System.out.println(this.getName() + " is " + traineeState);
	}

	@Override
	public void setTrainee(Observable trainee) {
		this.trainee = trainee;

	}

}
