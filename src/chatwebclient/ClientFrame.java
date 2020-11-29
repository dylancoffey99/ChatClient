package chatwebclient;

import chatwebservice.ChatWebService;
import chatwebservice.ChatWebService_Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ClientFrame extends JFrame implements ActionListener {
    private ChatWebService proxy;
    private ChatWebService_Service port;
    private JFrame parent;
    private int userid;
    String username;
    
    public ClientFrame(int u, JFrame pops) {
        parent = pops;
        port = new ChatWebService_Service();
        proxy = port.getChatWebServicePort();
        
        userid = u;
        
        // Frame Title and Size
        setTitle("Chat Web Client - Welcome");
        setSize(1000, 1000);
        
        // Panel & Layout
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout(); 
        panel.setLayout(layout);

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
        pops.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
