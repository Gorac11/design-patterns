package mediatorPackage;

import factoryPackage.User;

public interface MessageMediator {
	   void sendMessage(String message, User user);
	   void addUser(User user);
	   void deleteUser();
}
