import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class AddLibrarian extends JFrame {
    private JButton button1;
    private JPanel mainPanel;
    private JTextField userName;
    private JTextField userPass;
    private JTextField userMail;
    private JTextField userAddress;
    private JTextField userCity;
    private JTextField userContact;
    private JButton backButton;
    private JTextField userId;
    int flag =0;
    public AddLibrarian() {
        super("Add Librarian");

        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userName.getText();
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please enter a name!");
                    flag=1;

                }
                String password = userPass.getText();
                if(password.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please enter a password!");
                    flag=1;
                }
                String email = userMail.getText();
                if(!email.contains("@"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a correct email!");
                    flag=1;
                }
                String address = userAddress.getText();
                String city = userCity.getText();
                String contact_no=userContact.getText();
                if(!contact_no.matches("[0-9]+"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a correct contact number!");
                    flag=1;
                }
                if(flag ==0)
                {
                    int id = Integer.parseInt(userId.getText());
                    GlobalVariables.librarians[GlobalVariables.counter_librarians++] = new Librarian(username,password,email,address,city,contact_no,id);
                    JOptionPane.showMessageDialog(null,"Librarian Added Successfully");
                    try {
                        GlobalVariables.printLibrarians(GlobalVariables.librarians);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    dispose();
                    new AdminSection();
                }
                else
                {
                    dispose();
                    new AddLibrarian();
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminSection();
            }
        });
    }
}
