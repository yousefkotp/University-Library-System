import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AddStudent extends JFrame {


    private JPanel mainPanel;
    private JTextField userName;
    private JPasswordField userPass;
    private JTextField userMail;
    private JTextField userAddress;
    private JTextField userCity;
    private JTextField userContact;
    private JButton addStudentButton;
    private JButton backButton;
    private JTextField userID;
    int flag = 0;
    AddStudent(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();




        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminSection();
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userName.getText();
                String password = userPass.getText();
                String address = userAddress.getText();
                String mail = userMail.getText();
                String city = userCity.getText();
                String contact = userContact.getText();
                int id = Integer.parseInt(userID.getText());


                if(username.isEmpty() || password.isEmpty() || mail.isEmpty() || address.isEmpty() || city.isEmpty() || contact.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please enter information in required fields");
                    flag =1;
                }
                if(username.matches("[0-9]+"))
                {
                    flag=1;
                    JOptionPane.showMessageDialog(null,"Please enter correct name!");
                }
                if(city.matches("[0-9]+"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct city name!");
                    flag=1;
                }
                if(!mail.contains("@"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a correct email!");
                    flag =1;

                }
                if(!contact.matches("[0-9]+"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a correct contact no!");
                    flag =1;
                }
                if(flag ==0 )
                {
                    GlobalVariables.students[GlobalVariables.counter_students++] = new Student(username,password,mail,address,city,contact,id);
                    JOptionPane.showMessageDialog(null,"Student has been added successfully !");
                    try {
                        GlobalVariables.printStudents(GlobalVariables.students);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    dispose();
                    new AdminSection();
                }
                else{
                    dispose();
                    new AddStudent();
                }
            }
        });
    }
}
