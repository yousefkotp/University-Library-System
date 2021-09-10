import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianLoginForm extends JFrame{
    private JPanel mainPanel;
    private JTextField userName;
    private JPasswordField passwordField1;
    private JLabel userPass;
    private JButton loginButton;
    private JButton returnButton;

    LibrarianLoginForm() {
        setContentPane(this.mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                String user = userName.getText();
                String pass = passwordField1.getText();
                for (int i = 0; i < GlobalVariables.counter_librarians; i++) {
                    if (user.equals(GlobalVariables.librarians[i].getName()) && pass.equals(GlobalVariables.librarians[i].getPass())) {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    JOptionPane.showMessageDialog(null, "You successfully logged in!");
                    dispose();
                    new LibrarianSection();
                } else {
                    JOptionPane.showMessageDialog(null, "The name of password is incorrect");
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


