package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.Message;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class ThreadedChat extends Thread implements Runnable {
    private ChatWebService proxy;
    private int uid, sid;
    private JTextArea messageArea;   
    private String message, reciever;
    private List<Message> messages = new ArrayList<>(); 
    private List<Message> messagesCopy = new ArrayList<>(); 
    
    public ThreadedChat(ChatWebService p, int u, int s, String r) {     
        proxy = p;
        uid = u;
        sid = s;
        reciever = r;
      
        messageArea = new JTextArea(16,47);
        messagesCopy = proxy.getMessages(uid, sid, reciever, 0);
        messages = proxy.getMessages(uid, sid, reciever, 0);
        updateTextArea();
    }
    
    public void run() {        
        while(true) {
            messages = proxy.getMessages(uid, sid, reciever, 0);
            
            if(equalLists(messages, messagesCopy)) {    
                updateTextArea();
                messagesCopy = proxy.getMessages(uid, sid, reciever, 0); 
                
                try {           
                    sleep(3000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void updateTextArea() {
        for (int i = 0; i < messages.size(); i++) {
            message = messages.get(i).getMessage();
            messageArea.append(message + "\n");
        }
    }
    
    public boolean equalLists(List<Message> list, List<Message> listCopy) {     
        if(listCopy.containsAll(list)) {
            return true;
        } else {
            return false;
        }
    }
    
    public JTextArea getMessageArea() {
        return messageArea;
    }
}