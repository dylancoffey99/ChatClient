package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.Message;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ThreadedChat extends Thread {
    private ChatWebService proxy;
    private DefaultListModel dlm;
    private int uid, sid;
    private JList userList;
    private JTextArea messageArea;   
    private String sender, reciever, message, lastMessage;
    private List users;
    private List<Message> messages = new ArrayList<>();  
    
    public ThreadedChat(ChatWebService p, int u, int s, String username) {     
        proxy = p;
        uid = u;
        sid = s;
        sender = username;
        
        // Initialising and filling userList
        dlm = new DefaultListModel();
        userList = new JList(dlm);
        users = proxy.getUsers(true);
        fillUserList();
        
        if (userList != null) {
            // Reciever is the username at index 0 of userList
            reciever = (String) userList.getModel().getElementAt(0);
        }
        
        // Initialising and filling messageArea
        messageArea = new JTextArea(16,47);
        messages = proxy.getMessages(uid, sid, reciever, 0);
        
        if (!messages.contains(null)) {
            // The last message is the message at the last index of messages
            lastMessage = messages.get(messages.size()-1).getMessage();
            fillTextArea();
        }
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                sleep(1000);
                messages = proxy.getMessages(uid, sid, reciever, 0);
                
                if (!messages.contains(null)) {
                    message = messages.get(messages.size()-1).getMessage();
                    
                    if (!message.equals(lastMessage)) {
                        messageArea.append(message + "\n");
                        lastMessage = messages.get(messages.size()-1).getMessage();
                    }
                }
            } 
            catch (InterruptedException e) {
                messageArea.setText("");
                reciever = userList.getSelectedValue().toString();
                messages = proxy.getMessages(uid, sid, reciever, 0);
                
                if (!messages.contains(null)) {  
                    fillTextArea();
                    lastMessage = messages.get(messages.size()-1).getMessage();
                }
            }
        }
    }
    
    private void fillTextArea() {       
        for (int i = 0; i < messages.size(); i++) {
            message = messages.get(i).getMessage();
            messageArea.append(message + "\n");
        }
    }
    
    private void fillUserList() {
        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).equals(sender))
                dlm.addElement(users.get(i));
        }
    }
    
    public JList getUserList() {
        return userList;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }
}