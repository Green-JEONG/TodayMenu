import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;

    public Signup() {
        setTitle("Signup");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 180, 80, 25);
        panel.add(lblUsername);

        txtUsername = new JTextField(20);
        txtUsername.setBounds(100, 180, 165, 25);
        panel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 210, 80, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField(20);
        txtPassword.setBounds(100, 210, 165, 25);
        panel.add(txtPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm:");
        lblConfirmPassword.setBounds(30, 240, 80, 25);
        panel.add(lblConfirmPassword);

        txtConfirmPassword = new JPasswordField(20);
        txtConfirmPassword.setBounds(100, 240, 165, 25);
        panel.add(txtConfirmPassword);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(50, 300, 80, 25);
        panel.add(btnRegister);

        btnCancel = new JButton("Back");
        btnCancel.setBounds(160, 300, 80, 25);
        panel.add(btnCancel);

        add(panel);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 화면으로 돌아가기
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 로직 구현 (예: 사용자 저장)
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                } else {
                    // 회원가입 성공 로직
                    JOptionPane.showMessageDialog(null, "Signup successful!");
                    Login login = new Login();
                    login.setVisible(true);
                    dispose();
                }
            }
        });
    }
}

