import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DietSearch extends JFrame {
    private JTextField searchField;
    private JTextArea searchResults;
    private DefaultListModel<String> favoritesModel;
    private JList<String> favoritesList;
    private Map<String, String> foodDetails;
    private Map<String, String> foodRecipes;

    public DietSearch() {
        setTitle("식단 검색 기능");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 데이터 초기화
        initializeFoodData();

        // 검색 패널
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout(5, 5));
        searchField = new JTextField();
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFood();
            }
        });
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(btnSearch, BorderLayout.EAST);

        // 검색 결과 표시 영역
        searchResults = new JTextArea();
        searchResults.setEditable(false);
        JScrollPane searchScrollPane = new JScrollPane(searchResults);

        // 즐겨찾기 패널
        JPanel favoritesPanel = new JPanel();
        favoritesPanel.setLayout(new BorderLayout(5, 5));
        favoritesModel = new DefaultListModel<>();
        favoritesList = new JList<>(favoritesModel);
        JScrollPane favoritesScrollPane = new JScrollPane(favoritesList);
        JButton btnViewDetails = new JButton("상세 정보 보기");
        btnViewDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFoodDetails();
            }
        });
        favoritesPanel.add(new JLabel("즐겨찾기 목록"), BorderLayout.NORTH);
        favoritesPanel.add(favoritesScrollPane, BorderLayout.CENTER);
        favoritesPanel.add(btnViewDetails, BorderLayout.SOUTH);

        // 메인 프레임 구성
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchScrollPane, favoritesPanel);
        splitPane.setDividerLocation(300);

        add(searchPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
    }

    private void initializeFoodData() {
        // 식품 상세 정보 및 레시피 초기화
        foodDetails = new HashMap<>();
        foodRecipes = new HashMap<>();

        foodDetails.put("오트밀", "칼로리: 150kcal\n재료: 오트밀, 우유, 꿀");
        foodRecipes.put("오트밀", "1. 오트밀과 우유를 섞습니다.\n2. 꿀을 추가합니다.");

        foodDetails.put("닭가슴살 샐러드", "칼로리: 250kcal\n재료: 닭가슴살, 로메인, 방울토마토, 오이");
        foodRecipes.put("닭가슴살 샐러드", "1. 닭가슴살을 구워서 잘게 썹니다.\n2. 야채와 함께 섞습니다.");

        foodDetails.put("연어 구이", "칼로리: 300kcal\n재료: 연어, 소금, 후추, 올리브 오일");
        foodRecipes.put("연어 구이", "1. 연어에 소금과 후추로 간을 합니다.\n2. 올리브 오일에 구워냅니다.");
    }

    private void searchFood() {
        String query = searchField.getText().trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "검색어를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder results = new StringBuilder();
        for (String food : foodDetails.keySet()) {
            if (food.contains(query)) {
                results.append(food).append("\n");
            }
        }

        if (results.length() == 0) {
            searchResults.setText("검색 결과가 없습니다.");
        } else {
            searchResults.setText(results.toString());
            int response = JOptionPane.showConfirmDialog(this, "이 항목을 즐겨찾기에 추가하시겠습니까?", "즐겨찾기 추가", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                favoritesModel.addElement(query);
            }
        }
    }

    private void viewFoodDetails() {
        String selectedFood = favoritesList.getSelectedValue();
        if (selectedFood == null) {
            JOptionPane.showMessageDialog(this, "상세 정보를 볼 식품을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String details = foodDetails.get(selectedFood);
        String recipe = foodRecipes.get(selectedFood);
        if (details != null && recipe != null) {
            JOptionPane.showMessageDialog(this, "상세 정보:\n" + details + "\n\n레시피:\n" + recipe, "식품 상세 정보", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "해당 식품에 대한 정보가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DietSearch().setVisible(true);
        });
    }
}