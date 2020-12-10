package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.Message;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class ThreadedChat extends Thread {
    private ChatWebService proxy;
    private int uid, sid;
    private JTextArea messageArea;   
    private String message, reciever, lastMessage;
    private List<Message> messages = new ArrayList<>();  
    
    public ThreadedChat(ChatWebService p, int u, int s, String r) {     
        proxy = p;
        uid = u;
        sid = s;
        reciever = r;
        
        messageArea = new JTextArea(16,47);
    }
    
    @Override
    public void run() {   
        messages = proxy.getMessages(uid, sid, reciever, 0);
        lastMessage = messages.get(messages.size()-1).getMessage();
        fillTextArea();
        
        while(true) {
            messages = proxy.getMessages(uid, sid, reciever, 0);
            message = messages.get(messages.size()-1).getMessage();
            
            if (!message.equals(lastMessage)) {
                messageArea.append(message + "\n");
                lastMessage = messages.get(messages.size()-1).getMessage();
            }
            try {
                sleep(3000);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void fillTextArea() {       
        for (int i = 0; i < messages.size(); i++) {
            message = messages.get(i).getMessage();
            messageArea.append(message + "\n");
        }
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }
}