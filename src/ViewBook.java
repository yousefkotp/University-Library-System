import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBook extends JFrame {
    private JPanel mainPanel;
    private JList callList;
    private JList nameList;
    private JList authorList;
    private JList publisherList;
    private JList quantityList;
    private JButton returnButton;
    private JList idList;
    private JList issuedList;
    private JList dateList;
    private DefaultListModel CallNoModel;
    private DefaultListModel NameModel;
    private DefaultListModel AuthorModel;
    private DefaultListModel PublisherModel;
    private DefaultListModel QuantityModel;
    private DefaultListModel IdModel;
    private DefaultListModel IssuedModel;
    private DefaultListModel AddedDateModel;

    ViewBook(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    CallNoModel = new DefaultListModel();
    NameModel = new DefaultListModel();
    AuthorModel = new DefaultListModel();
    PublisherModel = new DefaultListModel();
    QuantityModel = new DefaultListModel();
    IdModel = new DefaultListModel();
    IssuedModel = new DefaultListModel();
    AddedDateModel = new DefaultListModel();

    idList.setModel(IdModel);
    for(int i=1;i<GlobalVariables.counter_books+1;i++)
    {
        IdModel.addElement(i);
    }
    issuedList.setModel(IssuedModel);
    for(int i=0;i<GlobalVariables.counter_books;i++)
    {
        IssuedModel.addElement(GlobalVariables.books[i].getIssued());
    }
    dateList.setModel(AddedDateModel);
    for(int i=0;i<GlobalVariables.counter_books;i++)
    {
        AddedDateModel.addElement(GlobalVariables.books[i].getAdded_date());
    }
    callList.setModel(CallNoModel);
    for(int i = 0;i<GlobalVariables.counter_books;i++){
        CallNoModel.addElement(GlobalVariables.books[i].getCall_no());
    }

    nameList.setModel(NameModel);
    for(int i = 0;i<GlobalVariables.counter_books;i++){
        NameModel.addElement(GlobalVariables.books[i].getName());
        }
    authorList.setModel(AuthorModel);
    for(int i = 0;i<GlobalVariables.counter_books;i++){
        AuthorModel.addElement(GlobalVariables.books[i].getAuthor());
        }
    publisherList.setModel(PublisherModel);
    for(int i=0;i<GlobalVariables.counter_books;i++){
        PublisherModel.addElement(GlobalVariables.books[i].getPublisher());
    }
    quantityList.setModel(QuantityModel);
    for(int i=0;i<GlobalVariables.counter_books;i++){
        QuantityModel.addElement(GlobalVariables.books[i].getQuantity());
    }


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibrarianSection();
            }
        });
    }
}
