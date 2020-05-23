package mediatorPackage;

import java.util.ArrayList;
import java.util.List;

import factoryPackage.User;

public class ChatMessageMediator implements MessageMediator{
	 private List<User> users;
	 private String naughtyWord;
	 private User sender;
	 private Boolean alert;
	 private Bot alertBot;

	    public ChatMessageMediator() {
	        this.users = new ArrayList<>();
	    }

	    @Override
	    public void sendMessage(String message, User user) {
	    	alert=false;
	        for (User u : this.users) {
	            if (u != user) {
	                u.receive(message);
		            if(u.getIsBot()==true) {		//If receiver is a bot, alert it!
		            	alert=true;
		            	alertBot=(Bot) u;
	                }
	            }
	            else if(u==user) {
	    	        sender=u;
	            }
	        }
	       
	        if(alert==true)						// If bot was alerted, make it check message!
	        alertBot.moderator(message);
	        }
	    
	    public String getNaughtyWord() {
			return naughtyWord;
		}
		
		public void setNaughtyWord(String word) {
			this.naughtyWord = word;
		}
		
		public User getSender() {
			return sender;
		}

	    @Override
	    public void addUser(User user) {
	        this.users.add(user);

	    }
	    public void listUsers() {
    		System.out.println("Users:");
	    	for(User user : users) {
	    		if(user!=users.get(0)) {
	    		System.out.print("|");
	    	}
	    		System.out.print(user.getName());
	    	}
    		System.out.println();
	    }

		@Override
		public void deleteUser() {
			this.users.remove(sender);
		}
}
