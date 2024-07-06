import javax.swing.*;
import java.awt.*;

public class ProfileSettings extends JFrame {
    private JTextField txtUsername;
    private JTextField txtAge;
    private JComboBox<String> cbGender;
    private JComboBox<String> cbActivityLevel;
    private JTextField txtHealthCondition;
    private JTextField txtDietPreferences;
    private JTextField txtAllergies;
    private JTextField txtEatingHabits;

    public ProfileSettings() {
        setTitle("프로필 설정");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        // Create and add components
        add(new JLabel("이름:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("나이:"));
        txtAge = new JTextField();
        add(txtAge);

        add(new JLabel("성별:"));
        cbGender = new JComboBox<>(new String[]{"남성", "여성", "기타"});
        add(cbGender);

        add(new JLabel("신체 활동 수준:"));
        cbActivityLevel = new JComboBox<>(new String[]{"낮음", "보통", "높음"});
        add(cbActivityLevel);

        add(new JLabel("건강 상태:"));
        txtHealthCondition = new JTextField();
        add(txtHealthCondition);

        add(new JLabel("식단 선호도:"));
        txtDietPreferences = new JTextField();
        add(txtDietPreferences);

        add(new JLabel("알러지:"));
        txtAllergies = new JTextField();
        add(txtAllergies);

        add(new JLabel("식습관:"));
        txtEatingHabits = new JTextField();
        add(txtEatingHabits);

        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(e -> saveProfile());
        add(btnSave);

        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(e -> dispose());
        add(btnCancel);
    }

    private void saveProfile() {
        // 데이터 저장 로직을 여기에 추가합니다.
        String username = txtUsername.getText();
        int age = Integer.parseInt(txtAge.getText());
        String gender = (String) cbGender.getSelectedItem();
        String activityLevel = (String) cbActivityLevel.getSelectedItem();
        String healthCondition = txtHealthCondition.getText();
        String dietPreferences = txtDietPreferences.getText();
        String allergies = txtAllergies.getText();
        String eatingHabits = txtEatingHabits.getText();

        // 예제: 콘솔에 데이터 출력
        System.out.println("이름: " + username);
        System.out.println("나이: " + age);
        System.out.println("성별: " + gender);
        System.out.println("신체 활동 수준: " + activityLevel);
        System.out.println("건강 상태: " + healthCondition);
        System.out.println("식단 선호도: " + dietPreferences);
        System.out.println("알러지: " + allergies);
        System.out.println("식습관: " + eatingHabits);

        JOptionPane.showMessageDialog(this, "프로필이 저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProfileSettings().setVisible(true);
        });
    }
}