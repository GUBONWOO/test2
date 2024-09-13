package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        // 창의 크기를 300x200으로 설정하고
        setSize(300, 200);
        // 창의 제목을 "Login"으로 설정한다.
        setTitle("Login");
        // 창을 모니터의 중앙에 오게 배치한다.
        setLocationRelativeTo(null);
        // 프레임을 3x1의 그리드 레이아웃으로 설정한다.
        setLayout(new GridLayout(3,1));

        JPanel p1 = new JPanel();

        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10); // 10자리 입력크기로 텍스트필드 가로폭을 조정

        p1.add(l1); // p1에 l1을 추가
        p1.add(t1); // p1에 t1을 추가

        add(p1); // 메인 프레임에 p1을 추가

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Password");
        JPasswordField t2 = new JPasswordField(10); // 10자리 입력크기로 패스워드필드 가로폭을 조정

        p2.add(l2); // p2에 l2를 추가
        p2.add(t2); // p2에 t2를 추가

        add(p2); // 메인 프레임에 p2를 추가

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("로그인");
        JButton b2 = new JButton("회원가입");

        // b1을 누르면 로그인을 수행한다.
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // t1에 입력된 텍스트를 가져온다.
                String id = t1.getText();
                // t2에 입력된 텍스트를 가져온다.
                String password = new String(t2.getPassword());

                File file = new File("./src/file","test.csv");
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    // 파일을 읽어온다.
                    String line = "";
                    boolean isLogin = false;
                    while((line = bufferedReader.readLine()) != null) {
                        String[] strArr = line.split(",");


                        if(id.equals(strArr[0]) && password.equals(strArr[1])) {
                            isLogin = true;
                            break;
                        }
                    }

                    if(isLogin) {
                        JOptionPane.showMessageDialog(null, "로그인 성공");
                        dispose();
                        new RegisterFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "로그인 실패");
                    }
                } catch (Exception e1) {
                    // 예외종류 출력
                    e1.printStackTrace();
                    System.out.println("파일생성실패");
                }
            }
        });

        // b2를 누르면 회원가입 창으로 이동
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 현재 창을 닫는다.
                dispose();
                // 회원가입 창을 띄운다.
                new RegisterFrame();

            }
        });



        p3.add(b1); // p3에 b1을 추가
        p3.add(b2); // p3에 b2를 추가

        add(p3); // 메인 프레임에 p3을 추가

        // 창을 보여준다. 기본(false)
        // 소스코드의 최하단에 위치시킨다.
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }


}
