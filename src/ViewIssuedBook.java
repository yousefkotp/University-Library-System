import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIssuedBook extends JFrame {

    private JPanel mainPanel;
    private JList idList;
    private JList bookCallNo;
    private JList idStudentList;
    private JList nameList;
    private JList contactList;
    private JList dateList;
    private JButton returnButton;
    private DefaultListModel IdModel;
    private DefaultListModel CallNoModel;
    private DefaultListModel IdStudentModel;
    private DefaultListModel StudentNameModel;
    private DefaultListModel StudentContactModel;
    private DefaultListModel IssueDateModel;

    ViewIssuedBook(){
        setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        IdModel = new DefaultListModel();
        CallNoModel = new DefaultListModel();
        IdStudentModel= new DefaultListModel();
        StudentNameModel = new DefaultListModel();
        StudentContactModel = new DefaultListModel();
        IssueDateModel = new DefaultListModel();

        idList.setModel(IdModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            IdModel.addElement(GlobalVariables.issuedbooks[i].getStudent().getId());
        }

        bookCallNo.setModel(CallNoModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            CallNoModel.addElement(GlobalVariables.issuedbooks[i].getCall_no());
        }

        idStudentList.setModel(IdStudentModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            IdStudentModel.addElement(GlobalVariables.issuedbooks[i].getStudent().getId());
        }

        nameList.setModel(StudentNameModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            StudentNameModel.addElement(GlobalVariables.issuedbooks[i].getStudent().getName());
        }

        contactList.setModel(StudentContactModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            StudentContactModel.addElement(GlobalVariables.issuedbooks[i].getStudent().getContact_no());
        }
        dateList.setModel(IssueDateModel);
        for(int i=0;i<GlobalVariables.counter_issued;i++){
            IssueDateModel.addElement(GlobalVariables.issuedbooks[i].getIssuedate());
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
