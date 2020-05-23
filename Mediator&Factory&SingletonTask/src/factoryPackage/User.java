package factoryPackage;

import mediatorPackage.ChatMessageMediator;

public abstract class User {
	private String username;
	private Boolean isBot;

	public String getName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public Boolean getIsBot() {
		return isBot;
	}
	public void setIsBot(Boolean isBot) {
		this.isBot=isBot;
	}
	
	//		-----MEDIATOR-----

    protected ChatMessageMediator mediator;

    public User(ChatMessageMediator mediator, String name,Boolean isBot) {
        this.mediator = mediator;
        this.username = name;
        this.isBot=isBot;
    }
    
    public User getSender() {
		 return this;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}
