package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.ChatWebService_Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ChatWebClient extends JFrame implements ActionListener {

    private ChatWebService proxy;
    private ChatWebService_Service port;
    private JButton login;
    private JButton register;
    
    public ChatWebClient() {
        port = new ChatWebService_Service();
        proxy = port.getChatWebServicePort();
        
        // Frame Title and Size
        setTitle("Chat Web Client");
        setSize(500, 500);
        
        // Panel & Layout
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout(); 
        panel.setLayout(layout);
        
        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to the Chat Web Client");
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcomeLabel, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, welcomeLabel, -60, SpringLayout.VERTICAL_CENTER, panel);
        panel.add(welcomeLabel);
        
        // Instructions Label
        JLabel instructionsLabel = new JLabel("Select one of the options below to proceed:");
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instructionsLabel, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, instructionsLabel, 35, SpringLayout.NORTH, welcomeLabel);
        panel.add(instructionsLabel);
             
        // Login Button
        login = new JButton("Login");
        login.addActionListener(this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, login, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, login, 35, SpringLayout.NORTH, instructionsLabel);
        panel.add(login);
        
        // Register Button
        register = new JButton("Register");
        register.addActionListener(this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, register, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, register, 45, SpringLayout.NORTH, login);
        panel.add(register);
        
        add(panel);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public ChatWebService getProxy() {
        return proxy;
    }
    
    public static void main(String[] args) {
        ChatWebClient myClient = new ChatWebClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Object source = e.getSource();
            if(source == login) {
                LoginFrame myLogin = new LoginFrame(this);
                setVisible(false);
            }
            if(source == register) {
                RegisterFrame myRegister = new RegisterFrame(this);
                setVisible(false);
            }
        } catch(Exception ee) {
            System.err.println(ee.getMessage());
        }
    }
    
}
