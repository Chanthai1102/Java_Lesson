package SchoolGUI.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame {
    private JTable table;
    private JTextField txtName;
    private JRadioButton rdoMale;
    private JRadioButton rdoFemale;
    private JComboBox<Integer> cboGrade;
    private JTextField txtAge;
    private int SelectedRow = -1;
    private JButton btnSave;
    private JButton btnDelete;
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
        addMouseClickEventToTable();
        this.setVisible(true);
    }

    private JPanel form(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5,2));

        JLabel lblName = new JLabel("Name");
        txtName = new JTextField();

        JLabel lblGender= new JLabel("Gender");
        rdoMale = new JRadioButton("Male");
        rdoFemale = new JRadioButton("Female");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoMale);
        buttonGroup.add(rdoFemale);
        JPanel jPGender = new JPanel(new FlowLayout());
        jPGender.add(rdoMale);
        jPGender.add(rdoFemale);

        JLabel lblGrade = new JLabel("Grade");
        cboGrade = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});

        JLabel lblAge = new JLabel("Age");
        txtAge = new JTextField();

        btnSave = new JButton("Save");
        btnSave.addActionListener(new  MyClickListener());
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new  MyClickListener());

        jPanel.add(lblName);
        jPanel.add(txtName);
        jPanel.add(lblGender);
        jPanel.add(jPGender);
        jPanel.add(lblGrade);
        jPanel.add(cboGrade);
        jPanel.add(lblAge);
        jPanel.add(txtAge);
        jPanel.add(btnSave);
        jPanel.add(btnDelete);

        return jPanel;
    }

    private class MyClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSave){
                SaveAndUpdate();
            }else if (e.getSource() == btnDelete){
                removeRowData();
            }

        }
    }

    private void removeRowData(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (SelectedRow != -1){
            model.removeRow(SelectedRow);
            SelectedRow = -1 ;
        }
    }

    private void SaveAndUpdate(){

        String gender = "Male";
        if (rdoFemale.isSelected()){
            gender = "Female";
        }
        if (SelectedRow != -1){ //Update row data
            table.setValueAt(txtName.getText(),SelectedRow,0);
            table.setValueAt(gender,SelectedRow,1);
            table.setValueAt(cboGrade.getSelectedItem().toString(),SelectedRow,2);
            table.setValueAt(txtAge.getText(),SelectedRow,3);
            SelectedRow = -1;
        }else {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] data = new Object[]{
                    txtName.getText(),
                    gender,
                    cboGrade.getSelectedItem().toString(),
                    txtAge.getText()
            };
            model.addRow(data);
        }
        clearForm();
    }

    private void clearForm(){
        txtName.setText("");
        rdoMale.setSelected(true);
        cboGrade.setSelectedIndex(0);
        txtAge.setText("");
    }

    private void addMouseClickEventToTable(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setFormValue();
            }
        });
    }

    private void setFormValue(){
        DefaultTableModel model= (DefaultTableModel) table.getModel();
        SelectedRow = table.getSelectedRow();
        Object name = model.getValueAt(SelectedRow,0);
        Object gender = model.getValueAt(SelectedRow,1);
        Object grade = model.getValueAt(SelectedRow,2);
        Object age = model.getValueAt(SelectedRow,3);

        txtName.setText(name.toString());
        if(gender.toString().equals("Male")){
            rdoMale.setSelected(true);
        }else {
            rdoFemale.setSelected(true);
        }
        cboGrade.setSelectedItem(Integer.parseInt(grade.toString()));
        txtAge.setText(age.toString());

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
