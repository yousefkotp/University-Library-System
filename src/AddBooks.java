import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddBooks extends JFrame{
    private JPanel mainPanel;
    private JTextField callNo;
    private JButton addBookButton;
    private JButton backButton;
    private JLabel userAuthor;
    private JTextField userName;
    private JTextField authorName;
    private JTextField publisherName;
    private JTextField quantity;
    private JLabel userPublisher;
    private JLabel userQuantity;
    int flag =0;
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = myDateObj.format(myFormatObj);
    AddBooks(){
        setContentPane(this.mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibrarianSection();
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String callno = callNo.getText();
                String name = userName.getText();
                String author=authorName.getText();
                String publisher = publisherName.getText();
                String quan = quantity.getText();


                if(name.isEmpty() || callno.isEmpty() || author.isEmpty() || publisher.isEmpty() || quan.isEmpty())
                {
                    flag =1;
                    JOptionPane.showMessageDialog(null,"Please enter the required fields");
                }
                if(author.matches("[0-9]+"))
                {
                    flag =1;
                    JOptionPane.showMessageDialog(null,"Please enter correct author name!");
                }
                if(name.matches("[0-9]+"))
                {
                    flag=1;
                    JOptionPane.showMessageDialog(null,"Please enter correct name ");
                }
                if(publisher.matches("[0-9]+"))
                {
                    flag=1;
                    JOptionPane.showMessageDialog(null,"Please enter correct publisher name!");
                }

                if(!quan.matches("[0-9]+"))
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct quantity");
                    flag =1;
                }


                if(flag ==0){
                    int quantity = Integer.parseInt(quan);
                    GlobalVariables.books[GlobalVariables.counter_books++] = new Books(callno,name,author,publisher,quantity,0,formattedDate);
                    JOptionPane.showMessageDialog(null,"Book Successfully added");
                    try {
                        GlobalVariables.printBooks(GlobalVariables.books);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    dispose();
                    new LibrarianSection();
                }
                else
                {
                    dispose();
                    new AddBooks();
                }

            }
        });
    }
}
