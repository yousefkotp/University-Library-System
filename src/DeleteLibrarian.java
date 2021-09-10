import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class DeleteLibrarian extends JFrame{
    private JPanel mainPanel;
    private JButton deleteButton;
    private JButton backButton;
    private JTextField userId;

    public DeleteLibrarian() {
        this.setContentPane(this.mainPanel);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminSection();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0,i=0;
                if(userId.getText().isEmpty())
                {
                    flag =0;
                    JOptionPane.showMessageDialog(null,"Please enter the id!");
                }

                int id = Integer.parseInt(userId.getText());
                for (i = 0; i < GlobalVariables.counter_librarians; i++) {
                    if (id == GlobalVariables.librarians[i].getId()) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    for(int j=i;j<GlobalVariables.counter_librarians-1;j++){
                        GlobalVariables.librarians[j] = GlobalVariables.librarians[j+1];
                    }
                    GlobalVariables.counter_librarians--;
                    JOptionPane.showMessageDialog(null,"Successfully deleted!");
                    try {
                        GlobalVariables.printLibrarians(GlobalVariables.librarians);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    dispose();
                    new AdminSection();

                } else {
                    JOptionPane.showMessageDialog(null, "Deleting failed, there is no such id!!");
                    dispose();
                    new AdminSection();
                }
            };
    });
}}

