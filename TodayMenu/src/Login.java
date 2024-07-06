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
                Signup signup = new Signup();
                signup.setVisible(true);
                dispose();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    Home home = new Home(username);
                    home.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }
}

