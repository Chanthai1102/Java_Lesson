package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudenApp {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setTitle("Student Form");
        frame.setSize(350,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        JLabel jblName = new JLabel("Name");
        jblName.setBounds(20,20,50,20);
        frame.add(jblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(120,20,150,25);
        frame.add(txtName);

        JLabel jblGender = new JLabel("Gender");
        jblGender.setBounds(20,70,50,20);
        frame.add(jblGender);

        JTextField txtGender = new JTextField();
        txtGender.setBounds(120,70,150,25);
        frame.add(txtGender);

        JLabel jblAge = new JLabel("Age");
        jblAge.setBounds(20,120,50,20);
        frame.add(jblAge);

        JTextField txtAge = new JTextField();
        txtAge.setBounds(120,120,150,25);
        frame.add(txtAge);

        JLabel jblGrade =  new JLabel("Grade");
        jblGrade.setBounds(20,170,50,20);
        frame.add(jblGrade);

        Integer[] grades = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12};
        JComboBox<Integer> cbxGrade = new JComboBox<>(grades);
        cbxGrade.setBounds(120,170,150,25);
        frame.add(cbxGrade);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(20,220,100,25);
        frame.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Work");
            }
        });


        frame.setVisible(true);
    }
}
