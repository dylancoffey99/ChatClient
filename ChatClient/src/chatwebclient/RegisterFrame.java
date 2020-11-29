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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RegisterFrame extends JFrame implements ActionListener {

    private ChatWebClient parent;
    private ChatWebService proxy;
    private ChatWebService_Service port;
    private ClientFrame client;
    private JButton submit, clear;
    private JLabel nameLbl, usernameLbl, passwordLbl, rptpasswordLbl;
    private JTextField name, username, password, rptpassword;
    
    public RegisterFrame(ChatWebClient pops) {
        parent = pops;
        port = new ChatWebService_Service();
        proxy = port.getChatWebServicePort();
        
        // Frame Title and Size
        setTitle("Registation");
        setSize(500, 210);
        
        // Panel & Layout
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout(); 
        panel.setLayout(layout);
        
        // Name Label & TextField
        nameLbl = new JLabel("Name:");
        name = new JTextField(30);
        layout.putConstraint(SpringLayout.NORTH, nameLbl, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLbl, 10, SpringLayout.WEST, panel); 
        layout.putConstraint(SpringLayout.NORTH, name, 10, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, name, 130, SpringLayout.WEST, nameLbl); 
        panel.add(nameLbl);
        panel.add(name);
         
        // Username Label & TextField
        usernameLbl = new JLabel("Username:");
        username = new JTextField(30);
        layout.putConstraint(SpringLayout.NORTH, usernameLbl, 30, SpringLayout.NORTH, nameLbl);
        layout.putConstraint(SpringLayout.WEST, usernameLbl, 10, SpringLayout.WEST, panel); 
        layout.putConstraint(SpringLayout.NORTH, username, 30, SpringLayout.NORTH, nameLbl); 
        layout.putConstraint(SpringLayout.WEST, username, 130, SpringLayout.WEST, usernameLbl); 
        panel.add(usernameLbl);
        panel.add(username);
        
        // Password Label & TextField
        passwordLbl = new JLabel("Password:");
        password = new JTextField(30);
        layout.putConstraint(SpringLayout.NORTH, passwordLbl, 30, SpringLayout.NORTH, usernameLbl);
        layout.putConstraint(SpringLayout.WEST, passwordLbl, 10, SpringLayout.WEST, panel); 
        layout.putConstraint(SpringLayout.NORTH, password, 30, SpringLayout.NORTH, usernameLbl); 
        layout.putConstraint(SpringLayout.WEST, password, 130, SpringLayout.WEST, passwordLbl); 
        panel.add(passwordLbl);
        panel.add(password);
        
        // Repeat Password Label & TextField
        rptpasswordLbl = new JLabel("Repeat Password:");
        rptpassword = new JTextField(30);
        layout.putConstraint(SpringLayout.NORTH, rptpasswordLbl, 30, SpringLayout.NORTH, passwordLbl);
        layout.putConstraint(SpringLayout.WEST, rptpasswordLbl, 10, SpringLayout.WEST, panel); 
        layout.putConstraint(SpringLayout.NORTH, rptpassword, 30, SpringLayout.NORTH, passwordLbl); 
        layout.putConstraint(SpringLayout.WEST, rptpassword, 130, SpringLayout.WEST, rptpasswordLbl); 
        panel.add(rptpasswordLbl);
        panel.add(rptpassword);
        
        // Clear Button
        clear = new JButton("Clear");
        clear.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, clear, 30, SpringLayout.NORTH, rptpasswordLbl); 
        layout.putConstraint(SpringLayout.WEST, clear, 10, SpringLayout.WEST, panel); 
        panel.add(clear);
        
        // Submit Button
        submit = new JButton("Submit");
        submit.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, submit, 30, SpringLayout.NORTH, rptpasswordLbl); 
        layout.putConstraint(SpringLayout.WEST, submit, 70, SpringLayout.WEST, clear); 
        panel.add(submit);
        
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setVisible(true);
                dispose();
            }
        };
        
        addWindowListener(exitListener);
        
        add(panel);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == clear) {
            name.setText("");
            username.setText("");
            password.setText("");
            rptpassword.setText("");
        }
        
        if(source == submit) {
            String n = name.getText();
            String u = username.getText();
            String p = password.getText();
            String rp = rptpassword.getText();
            
            int value = proxy.registerUser(n, u, p, rp);
            switch(value) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Unable to add credentials.\nTry again.");
                    username.setText("");
                    password.setText("");
                    username.requestFocusInWindow();
                break;
                
                case -1:
                    JOptionPane.showMessageDialog(null, "Problem with database.\nTry again later");
                    username.setText("");
                    password.setText("");
                    username.requestFocusInWindow();
                break;
                
                default:
                    name.setText("");
                    username.setText("");
                    password.setText("");
                    rptpassword.setText("");
                    username.requestFocusInWindow();
                    client = new ClientFrame(value, parent);
                    setVisible(false);
            }
        }
    }
}
