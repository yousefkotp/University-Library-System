import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginForm extends JFrame{
    private JPanel mainPanel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private JButton returnButton;
    private int flag=1;
    AdminLoginForm(){
        super("Admin Login Form");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = passText.getText();
                for(int i=0;i<GlobalVariables.counter_admin;i++) {
                    if (user.equals(GlobalVariables.admin[i].getUser()) && pass.equals(GlobalVariables.admin[i].getPass())) {
                        dispose();
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                        new AdminSection();
                        flag=0;
                    }
                }
                if(flag ==1){
                    JOptionPane.showMessageDialog(null,"The username of password is incorrect");
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibraryManagement();
            }
        });
    }
}
