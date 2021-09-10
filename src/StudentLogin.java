import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends JFrame{
    private JPanel mainPanel;
    private JTextField userName;
    private JPasswordField userPass;
    private JButton loginButton;
    private JButton returnButton;

    StudentLogin(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibraryManagement();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int flag=0;
                 int flagborrowed=0;
                 int i;
                 int counter=0;
                 String bookname1="";
                 String bookname2="";
                 String bookname3="";
                String name = userName.getText();
                String pass = userPass.getText();

                for(i=0;i<GlobalVariables.counter_students;i++)
                {
                    if(name.equals(GlobalVariables.students[i].getName()) &&pass.equals(GlobalVariables.students[i].getPassword())) {
                        flag = 1;
                    }
                }


                if(flag ==1){
                    for(i=0;i<GlobalVariables.counter_issued;i++)
                    {
                        if(name.equals(GlobalVariables.issuedbooks[i].student.getName()) && pass.equals(GlobalVariables.issuedbooks[i].student.getPassword()))
                        {
                            if(counter ==0){
                                bookname1=GlobalVariables.issuedbooks[i].getName();
                                counter++;
                            }
                            else if(counter ==1){
                                bookname2=GlobalVariables.issuedbooks[i].getName();
                                counter++;
                            }

                            else if(counter ==2) {
                                bookname3 = GlobalVariables.issuedbooks[i].getName();
                            }
                            flagborrowed =1;
                        }
                    }
                    if(flagborrowed ==1)
                        JOptionPane.showMessageDialog(null,"Books borrowed by student:\n"+bookname1+"\n"+bookname2+"\n"+bookname3);
                    else
                        JOptionPane.showMessageDialog(null,"This student didn't borrow any book!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"No student with such name or password!");
                    dispose();
                    new StudentLogin();
                }


            }
        });
    }
}
