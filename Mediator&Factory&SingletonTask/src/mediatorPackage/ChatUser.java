package mediatorPackage;

import factoryPackage.User;
import factoryPackage.UserFactory;
import mediatorPackage.ChatMessageMediator;

public class ChatUser extends User{
	//UserFactory userFactory=new UserFactory();
	 public ChatUser(ChatMessageMediator mediator, String name, Boolean isBot) {
	        super(mediator, name, isBot);
	        mediator.addUser(this);
	    }

	    @Override
	    public void send(String message) {
	        System.out.println("\n" + this.getName() + " sends: " + message);
	        mediator.sendMessage(message, this);
	        if(message.equals("addBot")) {
	        	UserFactory.createUser(mediator,"Bot",("Bot"+UserFactory.getBotCount()));
	        }
	    }

	    @Override
	    public void receive(String message) {
	        System.out.println(this.getName() + " receives: " + message);

	    }

}
