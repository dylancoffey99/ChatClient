package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.Message;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ThreadedChat extends Thread {
    private ChatWebService proxy;
    private DefaultListModel dlm;
    private int uid, sid;
    private JList userList;
    private JTextArea messageArea, multiArea;
    private String sender, reciever, message, multicast, messageTime, 
            multicastTime, messageSender, multicastSender, lastMessage, lastMulticast;
    private List users;
    private List<Message> messages = new ArrayList<>();
    private List<Message> multicasts = new ArrayList<>();
    
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
            fillMessageArea();
        }
        
        // Initialising and filling multiArea
        multiArea = new JTextArea(12,47);
        multicasts = proxy.getMulticast(sid, 0);
        
        if (!multicasts.contains(null)) {
            lastMulticast = multicasts.get(multicasts.size()-1).getMessage();
            fillMultiArea();
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
                    messageTime = messages.get(messages.size()-1).getTime();
                    messageSender = messages.get(messages.size()-1).getSender();
                    
                    if (!message.equals(lastMessage)) {
                        messageArea.append("[" + messageTime + "] - " + messageSender + "\n");
                        messageArea.append(message + "\n");
                        messageArea.append("\n");
                        lastMessage = messages.get(messages.size()-1).getMessage();
                    }
                }
                
                multicasts = proxy.getMulticast(sid, 0);
                
                if (!multicasts.contains(null)) {
                    multicast = multicasts.get(multicasts.size()-1).getMessage();
                    multicastTime = multicasts.get(multicasts.size()-1).getTime();
                    multicastSender = multicasts.get(multicasts.size()-1).getSender();
                    
                    if (!multicast.equals(lastMulticast)) {
                        multiArea.append("[" + multicastTime + "] - " + multicastSender + "\n");
                        multiArea.append(multicast + "\n");
                        multiArea.append("\n");
                        lastMulticast = multicasts.get(multicasts.size()-1).getMessage();
                    }
                }
            }
            catch (InterruptedException e) {
                messageArea.setText("");
                reciever = userList.getSelectedValue().toString();
                messages = proxy.getMessages(uid, sid, reciever, 0);
                
                if (!messages.contains(null)) {  
                    fillMessageArea();
                    lastMessage = messages.get(messages.size()-1).getMessage();
                }
            }
        }
    }
    
    private void fillMessageArea() {       
        for (int i = 0; i < messages.size(); i++) {
            message = messages.get(i).getMessage();
            messageTime = messages.get(i).getTime();
            messageSender = messages.get(i).getSender();
            messageArea.append("[" + messageTime + "] - " + messageSender + "\n");   
            messageArea.append(message + "\n");
            messageArea.append("\n");
        }
    }
    
    private void fillMultiArea() {       
        for (int i = 0; i < multicasts.size(); i++) {
            multicast = multicasts.get(i).getMessage();
            multicastTime = multicasts.get(i).getTime();
            multicastSender = multicasts.get(i).getSender();
            multiArea.append("[" + multicastTime + "] - " + multicastSender + "\n");   
            multiArea.append(multicast + "\n");
            multiArea.append("\n");
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
    
    public JTextArea getMultiArea() {
        return multiArea;
    }
    
}