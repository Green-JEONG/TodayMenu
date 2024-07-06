import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DietRecommendations extends JFrame {
    private String username;
    private int age;
    private String gender;
    private String activityLevel;
    private String healthCondition;
    private String dietPreferences;
    private String allergies;
    private String eatingHabits;

    private Map<String, String> foodDetails;
    private Map<String, String> foodRecipes;
    private Map<String, String> foodImages;

    public DietRecommendations(String username, int age, String gender, String activityLevel, String healthCondition,
                               String dietPreferences, String allergies, String eatingHabits) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.healthCondition = healthCondition;
        this.dietPreferences = dietPreferences;
        this.allergies = allergies;
        this.eatingHabits = eatingHabits;

        setTitle("식단 추천 받기");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 데이터 초기화
        initializeFoodData();

        // 사용자 프로필 패널
        JPanel profilePanel = new JPanel(new GridLayout(8, 1));
        profilePanel.add(new JLabel("이름: " + username));
        profilePanel.add(new JLabel("나이: " + age));
        profilePanel.add(new JLabel("성별: " + gender));
        profilePanel.add(new JLabel("신체 활동 수준: " + activityLevel));
        profilePanel.add(new JLabel("건강 상태: " + healthCondition));
        profilePanel.add(new JLabel("식단 선호도: " + dietPreferences));
        profilePanel.add(new JLabel("알러지: " + allergies));
        profilePanel.add(new JLabel("식습관: " + eatingHabits));

        // 추천 결과 패널
        JPanel recommendationsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        addRecommendation(recommendationsPanel, "아침: 오트밀과 과일", "오트밀");
        addRecommendation(recommendationsPanel, "점심: 닭가슴살 샐러드", "닭가슴살 샐러드");
        addRecommendation(recommendationsPanel, "저녁: 연어 구이", "연어 구이");

        add(profilePanel, BorderLayout.WEST);
        add(recommendationsPanel, BorderLayout.CENTER);
    }

    private void initializeFoodData() {
        // 식품 상세 정보 및 레시피 초기화
        foodDetails = new HashMap<>();
        foodRecipes = new HashMap<>();
        foodImages = new HashMap<>();

        foodDetails.put("오트밀", "칼로리: 150kcal\n재료: 오트밀, 우유, 꿀");
        foodRecipes.put("오트밀", "1. 오트밀과 우유를 섞습니다.\n2. 꿀을 추가합니다.");
        foodImages.put("오트밀", "path/to/breakfast.jpg");

        foodDetails.put("닭가슴살 샐러드", "칼로리: 250kcal\n재료: 닭가슴살, 로메인, 방울토마토, 오이");
        foodRecipes.put("닭가슴살 샐러드", "1. 닭가슴살을 구워서 잘게 썹니다.\n2. 야채와 함께 섞습니다.");
        foodImages.put("닭가슴살 샐러드", "path/to/lunch.jpg");

        foodDetails.put("연어 구이", "칼로리: 300kcal\n재료: 연어, 소금, 후추, 올리브 오일");
        foodRecipes.put("연어 구이", "1. 연어에 소금과 후추로 간을 합니다.\n2. 올리브 오일에 구워냅니다.");
        foodImages.put("연어 구이", "path/to/dinner.jpg");
    }

    private void addRecommendation(JPanel panel, String mealLabel, String foodName) {
        JPanel mealPanel = new JPanel(new BorderLayout());
        JLabel mealTitle = new JLabel(mealLabel, SwingConstants.CENTER);
        JLabel mealImage = new JLabel(new ImageIcon(foodImages.get(foodName)));
        JTextArea mealInfo = new JTextArea("상세 정보:\n" + foodDetails.get(foodName) + "\n\n레시피:\n" + foodRecipes.get(foodName));
        mealInfo.setEditable(false);
        mealPanel.add(mealTitle, BorderLayout.NORTH);
        mealPanel.add(mealImage, BorderLayout.CENTER);
        mealPanel.add(new JScrollPane(mealInfo), BorderLayout.SOUTH);
        panel.add(mealPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DietRecommendations("홍길동", 25, "남성", "보통", "건강함", "채식", "없음", "규칙적").setVisible(true);
        });
    }
}