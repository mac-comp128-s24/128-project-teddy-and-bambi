import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

// import edu.macalester.graphics.ui.Label;
// import edu.macalester.graphics.ui.DropDownList;

import java.util.*;

public class HeroPickerUi {
    // set up ui elements
    private CanvasWindow window;
    private TextField enemyTeamField;
    private TextField playerRoleField;
    // private DropDownList<String> roleDropDown;
    private Button findCounterButton;
    private GraphicsText resultLabel;

    private String heroCountersCSVpath;
    private String role;
    private List<String> enemyTeam;
    private HeroCounterData heroCountersData;
    private Map<String, Map<String, List<String>>> heroCounters;
    HeroCounterPicker heroCounterPicker = new HeroCounterPicker(heroCounters);
    

    public HeroPickerUi(String heroCountersCSVpath) {
        window = new CanvasWindow("Hero Counter Picker", 400, 300);
        heroCountersData = new HeroCounterData(heroCountersCSVpath);
        heroCounters = heroCountersData.convertCSVToMap();
        heroCounterPicker = new HeroCounterPicker(heroCounters);
        setupUI();
        setupEventHandlers();
    }

    private void setupUI() {
        GraphicsText enemyTeamLabel = new GraphicsText("Enter Enemy Heroes (comma-separated):");
        enemyTeamLabel.setPosition(20, 20);
        window.add(enemyTeamLabel);

        enemyTeamField = new TextField();
        enemyTeamField.setPosition(20, 50);
        enemyTeamField.setScale(500, 30);  
        window.add(enemyTeamField);

        GraphicsText roleLabel = new GraphicsText("Select Your Role:");
        roleLabel.setPosition(20, 90);
        window.add(roleLabel);

        playerRoleField = new TextField();
        playerRoleField.setPosition(20, 120);
        playerRoleField.setScale(360, 30);  
        window.add(playerRoleField);


        findCounterButton = new Button("Find Best Counter");
        findCounterButton.setPosition(20, 160);
        window.add(findCounterButton);

        resultLabel = new GraphicsText("");
        resultLabel.setPosition(20, 200);
        window.add(resultLabel);
    }

    private void setupEventHandlers() {
        findCounterButton.onClick(() -> {
            enemyTeam = Arrays.asList(enemyTeamField.getText().split("\\s*,\\s*"));
            role = playerRoleField.getText();

        
            String bestHero = heroCounterPicker.findBestCounterHero(enemyTeam, role);
            resultLabel.setText("Best Hero: " + bestHero);
        });
    }

    public static void main(String[] args) {
        new HeroPickerUi("res/hero_data.csv");
    }
}
// "Orisa, Junkrat, Pharah, Ana, Moira"