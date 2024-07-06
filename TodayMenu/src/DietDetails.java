import javax.swing.*;
import java.awt.*;

public class DietDetails extends JFrame {

    public DietDetails() {
        setTitle("식단 세부 정보");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        // 아침 식단 패널
        JPanel breakfastPanel = new JPanel(new BorderLayout());
        JLabel breakfastLabel = new JLabel("아침: 오트밀과 과일", SwingConstants.CENTER);
        JLabel breakfastImage = new JLabel(new ImageIcon("breakfast.jpg"));
        JTextArea breakfastInfo = new JTextArea("재료: 오트밀, 바나나, 딸기\n칼로리: 350kcal");
        breakfastInfo.setEditable(false);
        breakfastPanel.add(breakfastLabel, BorderLayout.NORTH);
        breakfastPanel.add(breakfastImage, BorderLayout.CENTER);
        breakfastPanel.add(breakfastInfo, BorderLayout.SOUTH);
        add(breakfastPanel);

        // 점심 식단 패널
        JPanel lunchPanel = new JPanel(new BorderLayout());
        JLabel lunchLabel = new JLabel("점심: 닭가슴살 샐러드", SwingConstants.CENTER);
        JLabel lunchImage = new JLabel(new ImageIcon("lunch.jpg"));
        JTextArea lunchInfo = new JTextArea("재료: 닭가슴살, 로메인, 방울토마토, 오이\n칼로리: 400kcal");
        lunchInfo.setEditable(false);
        lunchPanel.add(lunchLabel, BorderLayout.NORTH);
        lunchPanel.add(lunchImage, BorderLayout.CENTER);
        lunchPanel.add(lunchInfo, BorderLayout.SOUTH);
        add(lunchPanel);

        // 저녁 식단 패널
        JPanel dinnerPanel = new JPanel(new BorderLayout());
        JLabel dinnerLabel = new JLabel("저녁: 연어 구이와 야채", SwingConstants.CENTER);
        JLabel dinnerImage = new JLabel(new ImageIcon("dinner.jpg"));
        JTextArea dinnerInfo = new JTextArea("재료: 연어, 브로콜리, 당근\n칼로리: 450kcal");
        dinnerInfo.setEditable(false);
        dinnerPanel.add(dinnerLabel, BorderLayout.NORTH);
        dinnerPanel.add(dinnerImage, BorderLayout.CENTER);
        dinnerPanel.add(dinnerInfo, BorderLayout.SOUTH);
        add(dinnerPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DietDetails().setVisible(true);
        });
    }
}