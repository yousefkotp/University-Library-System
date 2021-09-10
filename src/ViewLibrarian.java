import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewLibrarian extends JFrame {

    private JPanel mainPanel;
    private JList nameList;
    private JList passList;
    private JList mailList;
    private JList addressList;
    private JList cityList;
    private JList contactList;
    private JButton returnButton;
    private JList idList;
    private JList JList;
    private DefaultListModel ListNameModel;
    private DefaultListModel ListPassModel;
    private DefaultListModel ListMailModel;
    private DefaultListModel ListAddressModel;
    private DefaultListModel ListCityModel;
    private DefaultListModel ListContactModel;
    private DefaultListModel ListIdModel;


    ViewLibrarian(){
        super("View Librarians");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        ListNameModel = new DefaultListModel();
        ListPassModel= new DefaultListModel();
        ListMailModel = new DefaultListModel();
        ListAddressModel = new DefaultListModel();
        ListCityModel = new DefaultListModel();
        ListContactModel = new DefaultListModel();
        ListIdModel = new DefaultListModel();
        idList.setModel(ListIdModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListIdModel.addElement(GlobalVariables.librarians[i].getId());
        }

        nameList.setModel(ListNameModel);

        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListNameModel.addElement(GlobalVariables.librarians[i].getName());
        }
        passList.setModel(ListPassModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListPassModel.addElement(GlobalVariables.librarians[i].getPass());
        }
        mailList.setModel(ListMailModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListMailModel.addElement(GlobalVariables.librarians[i].getEmail());
        }
        addressList.setModel(ListAddressModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListAddressModel.addElement(GlobalVariables.librarians[i].getAddress());
        }
        cityList.setModel(ListCityModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListCityModel.addElement(GlobalVariables.librarians[i].getCity());
        }
        contactList.setModel(ListContactModel);
        for(int i=0;i<GlobalVariables.counter_librarians;i++){
            ListContactModel.addElement(GlobalVariables.librarians[i].getContact_no());
        }
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminSection();
            }
        });
    }






}
