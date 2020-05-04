package mainPackage;

import java.util.Scanner;

import commandPackage.Command;
import commandPackage.Instructor;
import commandPackage.LieDownCommand;
import commandPackage.StandUpCommand;
import observerPackage.Observer;
import observerPackage.Viewer;

public class mainClass {

	public static void main(String[] args) {

		Instructor instructor=new Instructor("Instructor A");
		Trainee trainee=new Trainee("Ivan",true);	//Name=Ivan, Standing=true;
		
		Command lieDownCommand = new LieDownCommand(trainee);
		Command standUpCommand = new StandUpCommand(trainee);
		
		Boolean exitBool=false;
		
		//trainee.setDefaultStanding(true);		//Alternative way to set default position
												//Will override the constructor's state
		
		Observer obs1=new Viewer("Obs1");
		Observer obs2=new Viewer("Obs2");
		Observer obs3=new Viewer("Obs3");
		Observer obs4=new Viewer("Obs4");
		
		trainee.register(obs1);
		trainee.register(obs2);
		trainee.register(obs3);
		trainee.register(obs4);
		
		trainee.unregister(obs4);
		
		
		System.out.println("Type \"lie down\" or \"stand up\" for commands and \"exit\" to exit!");
		do {
			System.out.print("\n"+instructor.getName()+": ");
			
			Scanner in = new Scanner(System.in);

			String sc = in.nextLine();
		
			if(sc.equals("exit")) {
				System.out.println("Exit complete!");
				exitBool=true;
			}
			else if(sc.equals("lie down")) {
				instructor.setCommand(lieDownCommand);
			}
			else if(sc.equals("stand up")) {
				instructor.setCommand(standUpCommand);
			}
			else {
				System.out.println("Unrecognised command!");
			}
			
		} while(exitBool==false);
		
	}

}
