import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private String username;
    private int age;
    private String gender;
    private String goal;

    public Menu(String username, int age, String gender, String goal) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.goal = goal;

        setTitle("전체 메뉴");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JButton btnProfile = new JButton("프로필 설정");
        btnProfile.addActionListener(e -> showProfileSettings());
        panel.add(btnProfile);

        JButton btnDietDetails = new JButton("식단 세부 정보");
        btnDietDetails.addActionListener(e -> showDietDetails());
        panel.add(btnDietDetails);

        JButton btnSearchDiet = new JButton("식단 검색 기능");
        btnSearchDiet.addActionListener(e -> searchDiet());
        panel.add(btnSearchDiet);

        JButton btnGetRecommendations = new JButton("식단 추천 받기");
        btnGetRecommendations.addActionListener(e -> getDietRecommendations());
        panel.add(btnGetRecommendations);

        JButton btnDietJournal = new JButton("식단 일지 및 기록");
        btnDietJournal.addActionListener(e -> showDietJournal());
        panel.add(btnDietJournal);

        JButton btnImproveRecommendations = new JButton("추천 결과 개선");
        btnImproveRecommendations.addActionListener(e -> improveRecommendations());
        panel.add(btnImproveRecommendations);

        add(panel);
    }

    private void showProfileSettings() {
        // 프로필 설정 화면을 보여줍니다.
        String newUsername = JOptionPane.showInputDialog(this, "이름을 입력하세요:", username);
        if (newUsername != null && !newUsername.isEmpty()) {
            username = newUsername;
        }
        // 추가적인 사용자 정보 설정 코드가 여기에 추가됩니다.
        JOptionPane.showMessageDialog(this, "프로필 설정이 업데이트되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showDietDetails() {
        // 식단 세부 정보 화면을 보여줍니다.
        JOptionPane.showMessageDialog(this, "식단 세부 정보: \n아침: 오트밀\n점심: 닭가슴살 샐러드\n저녁: 연어 구이", "식단 세부 정보", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchDiet() {
        // 식단 검색 기능을 구현합니다.
        JOptionPane.showMessageDialog(this, "식단 검색 기능은 현재 개발 중입니다.", "식단 검색", JOptionPane.INFORMATION_MESSAGE);
    }

    private void getDietRecommendations() {
        // 식단 추천 받기 기능을 구현합니다.
        JOptionPane.showMessageDialog(this, "오늘의 추천 식단: \n아침: 오트밀과 과일\n점심: 닭가슴살 샐러드\n저녁: 연어 구이와 야채", "식단 추천", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showDietJournal() {
        // 식단 일지 및 기록 화면을 보여줍니다.
        JOptionPane.showMessageDialog(this, "식단 일지 및 기록 기능은 현재 개발 중입니다.", "식단 일지 및 기록", JOptionPane.INFORMATION_MESSAGE);
    }

    private void improveRecommendations() {
        // 추천 결과 개선 기능을 구현합니다.
        JOptionPane.showMessageDialog(this, "추천 결과 개선 기능은 현재 개발 중입니다.", "추천 결과 개선", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu("홍길동", 25, "남성", "체중 감량").setVisible(true);
        });
    }
}