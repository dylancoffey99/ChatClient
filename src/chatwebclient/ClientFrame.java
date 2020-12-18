package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.ChatWebService_Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClientFrame extends JFrame implements ActionListener, ListSelectionListener {
    private ChatWebService proxy;
    private ChatWebService_Service port;
    private int uid, sid;
    private JButton messageSend, multiSend, logout;
    private JFrame parent;
    private JLabel userLbl, messageLbl, multiLbl;
    private JList userList;
    private JScrollPane userListPane, messageAreaPane, multiAreaPane;
    private JTextArea messageArea, multiArea;
    private JTextField messageField, multiField;
    private ThreadedChat thread;
    
    public ClientFrame(int u, String username, JFrame pops) {
        parent = pops;
        port = new ChatWebService_Service();
        proxy = port.getChatWebServicePort();
        
        uid = u;
        sid = proxy.newSession(uid);
        
        thread = new ThreadedChat(proxy, uid, sid, username);
        thread.start();
        
        // Frame Title and Size
        setTitle("Chat Web Client - Welcome " + username);
        setSize(700, 700);
        
        // Panel & Layout
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout(); 
        panel.setLayout(layout);

        // User Label & User List with scrollable pane
        userLbl = new JLabel("Users:");
        userList = thread.getUserList();
        userList.setFixedCellHeight(35);
        userList.setFixedCellWidth(100);
        userList.addListSelectionListener(this);
        userList.setSelectedIndex(0);
        userListPane = new JScrollPane(userList);
        layout.putConstraint(SpringLayout.NORTH, userLbl, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userLbl, 20, SpringLayout.WEST, panel); 
        layout.putConstraint(SpringLayout.NORTH, userListPane, 10, SpringLayout.SOUTH, userLbl);
        layout.putConstraint(SpringLayout.WEST, userListPane, 20, SpringLayout.WEST, panel); 
        panel.add(userLbl);
        panel.add(userListPane);
        
        // Message Label + Message TextArea with scrollable pane
        messageLbl = new JLabel("Messages:");
        messageArea = thread.getMessageArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageAreaPane = new JScrollPane(messageArea);
        layout.putConstraint(SpringLayout.NORTH, messageLbl, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, messageLbl, 20, SpringLayout.EAST, userListPane); 
        layout.putConstraint(SpringLayout.NORTH, messageAreaPane, 10, SpringLayout.SOUTH, messageLbl);
        layout.putConstraint(SpringLayout.WEST, messageAreaPane, 20, SpringLayout.EAST, userListPane);
        panel.add(messageLbl);
        panel.add(messageAreaPane);
        
        // Message TextField
        messageField = new JTextField(47);
        layout.putConstraint(SpringLayout.NORTH, messageField, 4, SpringLayout.SOUTH, messageAreaPane);
        layout.putConstraint(SpringLayout.WEST, messageField, 20, SpringLayout.EAST, userListPane);
        panel.add(messageField);
         
        // Send Button
        messageSend = new JButton("Send Message");
        messageSend.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, messageSend, 4, SpringLayout.SOUTH, messageField);
        layout.putConstraint(SpringLayout.EAST, messageSend, -21, SpringLayout.EAST, panel);
        panel.add(messageSend);
        
        // Multicast Label & Multicast TextArea with scrollable pane
        multiLbl = new JLabel("Multicast Messages:");
        multiArea = thread.getMultiArea();
        multiArea.setEditable(false);
        multiArea.setLineWrap(true);
        multiAreaPane = new JScrollPane(multiArea);
        layout.putConstraint(SpringLayout.NORTH, multiLbl, 40, SpringLayout.SOUTH, messageField);
        layout.putConstraint(SpringLayout.WEST, multiLbl, 20, SpringLayout.EAST, userListPane); 
        layout.putConstraint(SpringLayout.NORTH, multiAreaPane, 10, SpringLayout.SOUTH, multiLbl);
        layout.putConstraint(SpringLayout.WEST, multiAreaPane, 20, SpringLayout.EAST, userListPane);
        panel.add(multiLbl);
        panel.add(multiAreaPane);
        
        // Multicast TextField
        multiField = new JTextField(47);
        layout.putConstraint(SpringLayout.NORTH, multiField, 4, SpringLayout.SOUTH, multiAreaPane);
        layout.putConstraint(SpringLayout.WEST, multiField, 20, SpringLayout.EAST, userListPane);
        panel.add(multiField);
         
        // Multicast Send Button
        multiSend = new JButton("Send Multicast");
        multiSend.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, multiSend, 4, SpringLayout.SOUTH, multiField);
        layout.putConstraint(SpringLayout.EAST, multiSend, -21, SpringLayout.EAST, panel);
        panel.add(multiSend);
        
        // Logout Button
        logout = new JButton("Logout");
        logout.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, logout, 4, SpringLayout.SOUTH, multiField);
        layout.putConstraint(SpringLayout.WEST, logout, 20, SpringLayout.WEST, panel);
        panel.add(logout);
        
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                proxy.logOut(uid, sid);
                parent.setVisible(true);
                dispose();
            }
        };
        
        addWindowListener(exitListener);
        
        add(panel);
        setVisible(true);
        setResizable(false);
        pops.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        thread.interrupt();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        try {
            if(source == messageSend) {
                String message = messageField.getText();
                String reciever = userList.getSelectedValue().toString();
                proxy.postMessage(uid, sid, reciever, message);
                messageField.setText("");
            }
        }
        catch(Exception ee) {
            JOptionPane.showMessageDialog(null, "User has not been selected!\nTry again.");
            messageField.setText("");
            messageField.requestFocusInWindow();
        }

        if(source == multiSend) {
            String message = multiField.getText();
            proxy.postMulticast(uid, sid, message);
            multiField.setText("");
        }
        
        if(source == logout) {
            proxy.logOut(uid, sid);
            parent.setVisible(true);
            dispose();
        }
    }
}
