

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setSize(200, 200);
        setTitle("Register");
        setLocationRelativeTo(null);

        // id, name, password, passwordCheck
        setLayout(new GridLayout(5,1));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Name");
        JTextField t2 = new JTextField(10);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Password");
        JPasswordField t3 = new JPasswordField(10);
        p3.add(l3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JLabel l4 = new JLabel("Password Check");
        JPasswordField t4 = new JPasswordField(10);
        p4.add(l4);
        p4.add(t4);

        JPanel p5 = new JPanel();
        JButton b1 = new JButton("register");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 각종 check

                // file에 쓰기를 실행
                String id = t1.getText();
                String name = t2.getText();
                String password = new String(t3.getPassword());
                String passwordCheck = new String(t4.getPassword());

                try {
                    File file = new File("./src/file","test.csv");
                    FileWriter writer = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    bufferedWriter.write(id + "," + password + "," + name);
                    bufferedWriter.newLine();
                    bufferedWriter.close();


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        p5.add(b1);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        setVisible(true);
        
    }


}
