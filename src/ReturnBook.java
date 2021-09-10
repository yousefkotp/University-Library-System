import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReturnBook extends JFrame {

    private JPanel mainPanel;
    private JTextField callNo;
    private JTextField userId;
    private JButton returnBookButton;
    private JButton backButton;
    int flag=0,i=0,l=0;
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = myDateObj.format(myFormatObj);
    ReturnBook(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibrarianSection();
            }
        });


        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String callno = callNo.getText();
                int id = Integer.parseInt(userId.getText());

                for(i=0;i<GlobalVariables.counter_issued;i++){
                    if(callno.equals(GlobalVariables.issuedbooks[i].getCall_no()) && id == GlobalVariables.issuedbooks[i].getStudent().getId()){
                        flag =1;
                        break;
                    }
                }


                if(flag ==1){
                    for(l=0;l<GlobalVariables.counter_students;l++){
                        if(id == GlobalVariables.students[l].getId())
                            GlobalVariables.students[l].setBorrowed(GlobalVariables.students[l].getBorrowed()-1);
                    }
                    for(i=0;i<GlobalVariables.counter_issued;i++) {
                        if(GlobalVariables.issuedbooks[i].getReturndate().compareTo(formattedDate)<0){
                            JOptionPane.showMessageDialog(null,"This student is late, he will be penalized!");
                            break;
                        }
                    }
                    for(int j=i;j<GlobalVariables.counter_issued-1;j++)
                    {
                        GlobalVariables.issuedbooks[j] = GlobalVariables.issuedbooks[j+1];
                    }
                    GlobalVariables.counter_issued--;

                    GlobalVariables.books[i].setQuantity(GlobalVariables.books[i].getQuantity()+1);
                    GlobalVariables.books[i].setIssued(GlobalVariables.books[i].getIssued()-1);
                    JOptionPane.showMessageDialog(null,"Book returned Successfully!");
                    try {
                        GlobalVariables.printBooks(GlobalVariables.books);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    try {
                        GlobalVariables.printIssuesBooks(GlobalVariables.issuedbooks);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    try {
                        GlobalVariables.printStudents(GlobalVariables.students);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    dispose();
                    new LibrarianSection();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Sorry, unable to return book!");
                    dispose();
                    new LibrarianSection();
                }
            }
        });
    }
}
