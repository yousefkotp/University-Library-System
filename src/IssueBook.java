import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class IssueBook extends JFrame {
    private JTextField userId;
    private JTextField callNo;
    private JTextField studentId;
    private JTextField studentName;
    private JTextField studentContact;
    private JButton issueBookButton;
    private JButton backButton;
    private JTextField issueDate;
    private JPanel mainPanel;
    private JTextField returnDate;
    private int flag=0;
    private int j=0;        //used to discover index of the book
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = myDateObj.format(myFormatObj);
    public IssueBook() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);


        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String callno = callNo.getText();
                String studentidd = studentId.getText();
                String studentname = studentName.getText();
                String studentcontact= studentContact.getText();
                String date = returnDate.getText();
                int studentid = Integer.parseInt(studentidd);
                int i,l;

                for(i=0;i<GlobalVariables.counter_students;i++)
                {
                    if(studentid == GlobalVariables.students[i].getId() && studentcontact.equals(GlobalVariables.students[i].getContact_no()) && studentname.equals(GlobalVariables.students[i].getName())) {
                        flag = 1;
                        break;
                    }
                }
                for(l=0;l<GlobalVariables.counter_students;l++) {
                    if (GlobalVariables.students[l].getId() == studentid) {
                        if(GlobalVariables.students[l].borrowed>=3){
                            flag = 0;
                            JOptionPane.showMessageDialog(null, "This student can't borrow more books");
                        }
                    }
                }




                if (flag ==1)
                {
                    Student s= new Student(GlobalVariables.students[i].getName(),GlobalVariables.students[i].getPassword(),GlobalVariables.students[i].getEmail(),GlobalVariables.students[i].getAddress(),GlobalVariables.students[i].getCity(),GlobalVariables.students[i].getContact_no(),GlobalVariables.students[i].getId(),GlobalVariables.students[i].getBorrowed());
                    GlobalVariables.issuedbooks[GlobalVariables.counter_issued] = new IssuedBooks(callno,s,date);
                    GlobalVariables.students[i].setBorrowed(GlobalVariables.students[i].getBorrowed()+1);
                    for(j=0;j<GlobalVariables.counter_books;j++)
                    {
                        if(GlobalVariables.books[j].getCall_no().equals(callno))
                        {
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setStudent(s);
                            GlobalVariables.books[j].setQuantity(GlobalVariables.books[j].getQuantity()-1);
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].student.setBorrowed(GlobalVariables.issuedbooks[GlobalVariables.counter_issued].student.borrowed + 1);
                            GlobalVariables.books[j].setIssued(GlobalVariables.books[j].getIssued()+1);
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setIssuedate(formattedDate);
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setName( GlobalVariables.books[j].getName());
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setAuthor( GlobalVariables.books[j].getAuthor());
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setQuantity( GlobalVariables.books[j].getQuantity());
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setPublisher( GlobalVariables.books[j].getPublisher());
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setAdded_date( GlobalVariables.books[j].getAdded_date());
                            GlobalVariables.issuedbooks[GlobalVariables.counter_issued].setReturndate(date);
                            break;
                        }
                    }

                    GlobalVariables.counter_issued++;
                    JOptionPane.showMessageDialog(null,"The book was issued successfully");
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
                else
                {

                    dispose();
                    new IssueBook();
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibrarianSection();
            }
        });
    }
}
