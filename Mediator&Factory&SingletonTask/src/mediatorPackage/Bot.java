package mediatorPackage;

import factoryPackage.User;
import factoryPackage.UserFactory;

public class Bot extends User{
	//UserFactory userFactory=new UserFactory();

	public Bot(ChatMessageMediator mediator, String username,Boolean isBot) {
		super(mediator, username,isBot);
        mediator.addUser(this);
        this.setIsBot(true);
	}
	
	@Override
	public void send(String message) {
		  System.out.println("\n" + this.getName() + " sends: " + message);
	        mediator.sendMessage(message, this);	
	}

	@Override
	public void receive(String message) {
        System.out.println(this.getName() + " receives: " + message);		
	}
	
	public void moderator(String message) {
		if(message.contains(mediator.getNaughtyWord()) && mediator.getSender().getIsBot()==false) {
			message=mediator.getSender().getName()+" was removed! \""
					+mediator.getNaughtyWord()+"\" is a banned word!";
        	mediator.deleteUser();
        	send(message);
		}
	}
}
