package observer;

public class PackageBoyObserver implements Observer {

	private String name;
	private Observable desk;
	
	public PackageBoyObserver(String name) {
		this.setName(name);
	}

	@Override
	public void update() {
		if(desk == null) {
			System.out.println("No desk");
			return;
		}
		
		String deskName = desk.getDeskName();
		System.out.println(this.getName() + ": moving package from "+deskName);
		
	}
	@Override
	public void setDesk(Observable desk) {
		this.desk = desk;
	}
	
	public String getName() {	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
