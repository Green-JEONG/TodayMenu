import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    public Home(String username) {
        setTitle("Home");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("오늘의 메뉴 추천", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Create a text area to display the diet recommendation
        JTextArea dietRecommendation = new JTextArea(getDietRecommendation());
        dietRecommendation.setEditable(false);
        dietRecommendation.setLineWrap(true);
        dietRecommendation.setWrapStyleWord(true);
        panel.add(new JScrollPane(dietRecommendation), BorderLayout.CENTER);

        JButton btnUserInfo = new JButton("입력된 사용자 정보 보기");
        btnUserInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, getUserInfo(username), "사용자 정보", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(btnUserInfo, BorderLayout.EAST);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        });
        panel.add(btnLogout, BorderLayout.SOUTH);

        add(panel);
    }

    private String getDietRecommendation() {
        // This is a placeholder for actual diet recommendation logic
        return "아침: 오트밀과 과일\n점심: 닭가슴살 샐러드\n저녁: 연어 구이와 야채";
    }

    private String getUserInfo(String username) {
        // This is a placeholder for actual user information fetching logic
        return "사용자 이름: " + username + "\n연령: 25\n성별: 남성\n목표: 체중 감량";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Home("홍길동").setVisible(true);
        });
    }
}