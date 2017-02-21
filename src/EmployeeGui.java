import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by mdebiase on 2/8/2017.
 */
public class EmployeeGui extends JFrame{
    private JList EmployeeJList;
    private JScrollPane EmployeeListScrollPane;
    private JTextField EmployeeNameTextField;
    private JTextField EmployeeTitleTextField;
    private JButton CommitButton;
    private JSpinner EmployeeSalarySpinner;
    private JPanel MainPanel;
    private JSpinner EmployeeAgeSpinner;

    private EmployeeListModel EmployeeList;
   // private JTextField EmployeeTitleTextField;

    public EmployeeGui(){
        super ("Employee Database"); // set frame title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //tie GUI into data container
        this.EmployeeList = new EmployeeListModel();
        this.EmployeeJList.setModel(this.EmployeeList);

        //listen for button Clicks
        this.CommitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {addEmployee();

                    }
                });

        this.display();
    }

    private void addEmployee(){
        Employee e = new Employee(this.EmployeeNameTextField.getText());
        e.empAge((int)this.EmployeeAgeSpinner.getValue());
        e.empDesignation(this.EmployeeTitleTextField.getText());
        e.empSalary((int)this.EmployeeSalarySpinner.getValue());

        this.EmployeeList.addEmployee(e);

        EmployeeNameTextField.setText("");

        //TODO Debug reminder to remove
        //e.printEmployee();
    }

    //Finalize and show GUI to user
    private void display () {
        this.setContentPane(this.MainPanel);
        this.pack();
        this.setVisible(true);
    }
}
