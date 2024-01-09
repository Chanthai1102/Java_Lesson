package SchoolGUI.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    private JTable table;
    public StudentForm(){
        this.setTitle("Student Form");
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Components
        this.getContentPane().add(form(),BorderLayout.NORTH);
        table = table();
        JScrollPane js = new JScrollPane();
        js.getViewport().add(table);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[] {"Thai","Male",11,23});
        this.getContentPane().add(js);
        this.setVisible(true);
    }

    private JPanel form(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5,2));

        JLabel lblName = new JLabel("Name");
        JTextField txtName = new JTextField();

        JLabel lblGender= new JLabel("Gender");
        //JComboBox<String> cboGender = new JComboBox<>(new String[]{"Male","Female"});
        JRadioButton rdoMale = new JRadioButton("Male");
        JRadioButton rdoFemale = new JRadioButton("Female");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoMale);
        buttonGroup.add(rdoFemale);
        JPanel jPGender = new JPanel(new FlowLayout());
        jPGender.add(rdoMale);
        jPGender.add(rdoFemale);

        JLabel lblGrade = new JLabel("Grade");
        JComboBox<Integer> cboGrade = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});

        JLabel lblAge = new JLabel("Age");
        JTextField txtAge = new JTextField();

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[] {"Thai","Male",11,23});
            }
        });

        jPanel.add(lblName);
        jPanel.add(txtName);
        jPanel.add(lblGender);
        jPanel.add(jPGender);
        jPanel.add(lblGrade);
        jPanel.add(cboGrade);
        jPanel.add(lblAge);
        jPanel.add(txtAge);
        jPanel.add(btnSave);

        return jPanel;
    }


    private JTable table(){
        String[] columnName = {"Name","Gender","Grade","Age"};
        Object[][] rowData = {
                {"Dara","Male",10,16},
                {"Thida","Female",11,18},
        };

        DefaultTableModel model = new DefaultTableModel(rowData,columnName);
        JTable table = new JTable(model);
        return table;
    }
}
