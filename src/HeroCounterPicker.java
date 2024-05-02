import java.util.*;

public class HeroCounterPicker {
    private Map<String, Map<String, List<String>>> heroCounters;

    public HeroCounterPicker(Map<String, Map<String, List<String>>> heroCounters) {
     
        this.heroCounters = heroCounters;
    }

    public String findBestCounterHero(List<String> enemyTeam, String role) {
        Map<String, Integer> counterScores = new HashMap<>();
        String type;
    
        // Determine the type of counter based on the role
        if (role.equals("Tank")) {
            type = "Tank Counters";
        } else if (role.equals("Damage")) {
            type = "Damage Counters";
        } else if (role.equals("Support")) {
            type = "Support Counters";
        } else {
            return "Invalid role";
        }
    
        // Calculate the score for each hero based on how many enemies they can counter from the specified role
        for (Map.Entry<String, Map<String, List<String>>> heroEntry : heroCounters.entrySet()) {
            String hero = heroEntry.getKey();
            Map<String, List<String>> counters = heroEntry.getValue();
            List<String> relevantCounters = counters.getOrDefault(type, new ArrayList<>());
            int score = 0;
            
            for (String enemy : enemyTeam) {
                if (relevantCounters.contains(enemy)) {
                    score++;
                }
            }
            
            counterScores.put(hero, score);
        }
    
        // Determine the hero with the highest score
        return counterScores.entrySet().stream()
                            .max(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .orElse("No effective counter found");
    }
    

    

    public static void main(String[] args) {
        HeroCounterData converter = new HeroCounterData("res/hero_data.csv");
        Map<String, Map<String, List<String>>> data = converter.convertCSVToMap();
        HeroCounterPicker strategy = new HeroCounterPicker(data);
        List<String> enemyTeam = Arrays.asList("Sigma", "Junkrat", "Pharah", "Ana", "Moira");
        String bestHero = strategy.findBestCounterHero(enemyTeam, "Tank");
        System.out.println("Best hero to counter the given team: " + bestHero);
    }
}
