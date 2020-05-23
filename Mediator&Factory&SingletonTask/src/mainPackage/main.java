package mainPackage;

import factoryPackage.User;
import factoryPackage.UserFactory;
import mediatorPackage.ChatMessageMediator;

public class main {

	public static void main(String[] args) {
		
		   ChatMessageMediator mediator = new ChatMessageMediator();
		   
		   mediator.setNaughtyWord("cat");
	     
	   //  UserFactory userFactory = new UserFactory();	//Used Static so iterating bots is easier
		
			User user1= UserFactory.createUser(mediator, "User", "Peter");
			User user2= UserFactory.createUser(mediator, "User", "Ivan");
			User user3= UserFactory.createUser(mediator, "User", "Georgi");
				
	        mediator.listUsers();

	        user1.send("Hi All");
	        user2.send("addBot");   

	        user3.send("addBot");   

	        user1.send("catty");
	        user3.send("Hell Yeah");
	        
	        mediator.listUsers();

	}

}
