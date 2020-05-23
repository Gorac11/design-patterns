package factoryPackage;

import mediatorPackage.Bot;
import mediatorPackage.ChatMessageMediator;
import mediatorPackage.ChatUser;

public class UserFactory  {

		private static int botCount=1;
	
public static User createUser(ChatMessageMediator mediator,String userType,String username) {
		
		User user = null;
		
		if(userType.equals("User")) {
			user = new ChatUser(mediator, username, false); //mediator?, username?, isBot?
		}
		
		if(userType.equals("Bot")) {
			botCount++;
			user = new Bot(mediator, username, true);		//mediator?, username?, isBot?
		}
		
		return user;
	}

	public static int getBotCount() {
	return botCount;
	}
}


