import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSection extends JFrame{
    private JPanel mainPanel;
    private JButton viewLibrarianButton;
    private JButton deleteLibrarianButton;
    private JButton logoutButton;
    private JButton addLibrarianButton;
    private JButton addStudentButton;

    AdminSection(){
        setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LibraryManagement();
            }
        });
        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddLibrarian();
            }
        });
        viewLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewLibrarian();
            }
        });
        deleteLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeleteLibrarian();
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddStudent();
            }
        });
    }
}
