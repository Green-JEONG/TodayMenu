import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DietJournal extends JFrame {
    private String username;
    private int age;
    private String gender;
    private String activityLevel;
    private int recommendedCalories;
    private Map<String, Integer> dailyIntake; // 날짜별 섭취 칼로리
    private Map<String, Map<String, Integer>> nutrientIntake; // 날짜별 영양소 섭취 정보

    public DietJournal(String username, int age, String gender, String activityLevel) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.recommendedCalories = calculateRecommendedCalories();

        setTitle("식단 일지 및 기록");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 데이터 초기화
        initializeData();

        // 날짜 선택 패널
        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel lblDate = new JLabel("날짜 선택: ");
        JComboBox<String> cbDate = new JComboBox<>(dailyIntake.keySet().toArray(new String[0]));
        cbDate.addActionListener(e -> updateDataForDate((String) cbDate.getSelectedItem()));
        datePanel.add(lblDate, BorderLayout.WEST);
        datePanel.add(cbDate, BorderLayout.CENTER);

        // 섭취 정보 패널
        JPanel intakePanel = new JPanel(new GridLayout(1, 2));

        JTextArea intakeInfo = new JTextArea();
        intakeInfo.setEditable(false);
        intakePanel.add(new JScrollPane(intakeInfo));

        JPanel chartPanel = new JPanel(new BorderLayout());
        updateDataForDate((String) cbDate.getSelectedItem(), intakeInfo, chartPanel);

        intakePanel.add(chartPanel);

        add(datePanel, BorderLayout.NORTH);
        add(intakePanel, BorderLayout.CENTER);
    }

    private void initializeData() {
        dailyIntake = new HashMap<>();
        nutrientIntake = new HashMap<>();

        // 예제 데이터 추가
        dailyIntake.put("2024-06-10", 2000);
        dailyIntake.put("2024-06-11", 2200);
        dailyIntake.put("2024-06-12", 1800);

        Map<String, Integer> nutrientsDay1 = new HashMap<>();
        nutrientsDay1.put("탄수화물", 250);
        nutrientsDay1.put("단백질", 80);
        nutrientsDay1.put("지방", 70);
        nutrientIntake.put("2024-06-10", nutrientsDay1);

        Map<String, Integer> nutrientsDay2 = new HashMap<>();
        nutrientsDay2.put("탄수화물", 260);
        nutrientsDay2.put("단백질", 90);
        nutrientsDay2.put("지방", 75);
        nutrientIntake.put("2024-06-11", nutrientsDay2);

        Map<String, Integer> nutrientsDay3 = new HashMap<>();
        nutrientsDay3.put("탄수화물", 230);
        nutrientsDay3.put("단백질", 70);
        nutrientsDay3.put("지방", 60);
        nutrientIntake.put("2024-06-12", nutrientsDay3);
    }

    private void updateDataForDate(String date) {
        // This method will be called by the JComboBox action listener
        updateDataForDate(date, null, null);
    }

    private void updateDataForDate(String date, JTextArea intakeInfo, JPanel chartPanel) {
        int calories = dailyIntake.getOrDefault(date, 0);
        Map<String, Integer> nutrients = nutrientIntake.getOrDefault(date, new HashMap<>());

        if (intakeInfo != null) {
            intakeInfo.setText("날짜: " + date + "\n");
            intakeInfo.append("섭취 칼로리: " + calories + " kcal\n");
            intakeInfo.append("탄수화물: " + nutrients.getOrDefault("탄수화물", 0) + " g\n");
            intakeInfo.append("단백질: " + nutrients.getOrDefault("단백질", 0) + " g\n");
            intakeInfo.append("지방: " + nutrients.getOrDefault("지방", 0) + " g\n");
            intakeInfo.append("권장 칼로리: " + recommendedCalories + " kcal\n");
        }

        if (chartPanel != null) {
            JFreeChart barChart = createNutrientChart(nutrients);
            ChartPanel chart = new ChartPanel(barChart);
            chartPanel.removeAll();
            chartPanel.add(chart, BorderLayout.CENTER);
            chartPanel.revalidate();
        }
    }

    private JFreeChart createNutrientChart(Map<String, Integer> nutrients) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : nutrients.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }

        return ChartFactory.createBarChart(
                "영양소 섭취 정보",
                "영양소",
                "양 (g)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

    private int calculateRecommendedCalories() {
        // 사용자 정보에 따라 권장 칼로리 계산
        int baseCalories = 2000;
        if (activityLevel.equals("낮음")) {
            baseCalories -= 200;
        } else if (activityLevel.equals("높음")) {
            baseCalories += 200;
        }

        if (gender.equals("남성")) {
            baseCalories += 200;
        } else if (gender.equals("여성")) {
            baseCalories -= 200;
        }

        return baseCalories;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DietJournal("홍길동", 25, "남성", "보통").setVisible(true);
        });
    }
}