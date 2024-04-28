import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HeroCounterData {
    private String path;

    public HeroCounterData(String path) {
        this.path = path;
    }

    public Map<String, Map<String, List<String>>> convertCSVToMap() {
        Map<String, Map<String, List<String>>> heroCounters = new HashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String[] categories = br.readLine().split(","); // Read headers

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String hero = data[0];
                Map<String, List<String>> counters = new HashMap<>();

                for (int i = 1; i < data.length; i++) {
                    List<String> counterHeroes = new ArrayList<>();
                    if (!data[i].isEmpty()) {
                        String[] heroes = data[i].replace("\"", "").split(", ");
                        counterHeroes.addAll(Arrays.asList(heroes));
                    }
                    counters.put(categories[i], counterHeroes);
                }
                
                heroCounters.put(hero, counters);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return heroCounters;
    }

    public static void main(String[] args) {
        HeroCounterData converter = new HeroCounterData("res/hero_data.csv");
        Map<String, Map<String, List<String>>> data = converter.convertCSVToMap();
        
        // Print the data to check
        data.forEach((hero, counters) -> {
            System.out.println("Hero: " + hero);
            counters.forEach((type, heroes) -> {
                System.out.println("  " + type + ": " + heroes);
            });
        });
    }
}
