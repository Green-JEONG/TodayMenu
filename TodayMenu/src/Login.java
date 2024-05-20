import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnSignup;

    public Login() {
        setTitle("Login");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setBounds(30, 220, 80, 25);
        panel.add(lblUsername);

        txtUsername = new JTextField(20);
        txtUsername.setBounds(100, 220, 165, 25);
        panel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setBounds(30, 250, 80, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField(20);
        txtPassword.setBounds(100, 250, 165, 25);
        panel.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 300, 80, 25);
        panel.add(btnLogin);

        btnSignup = new JButton("Signup");
        btnSignup.setBounds(160, 300, 80, 25);
        panel.add(btnSignup);

        add(panel);

        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 화면으로 이동
                Signup signup = new Signup();
                signup.setVisible(true);
                dispose();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 로직 구현 (예: 사용자 인증)
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // 로그인 성공 후의 로직
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }
}

