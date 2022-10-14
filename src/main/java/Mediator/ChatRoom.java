package Mediator;

import java.util.Date;

public class ChatRoom implements ChatRoomMediator{

    public ChatRoom(){

    }

    @Override
    public void showMessage(User user, String message) {
        Date date = new Date();
        String sender = user.getName();

        System.out.println( date.getTime()  + "[" + sender  + "] " + message);
    }
}