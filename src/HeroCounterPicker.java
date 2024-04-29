import java.util.*;

public class HeroCounterPicker {
    private Map<String, Map<String, List<String>>> heroCounters;

    public HeroCounterPicker(Map<String, Map<String, List<String>>> heroCounters) {
     
        this.heroCounters = heroCounters;
    }

    public String findBestCounterHero(List<String> enemyTeam) {
        Map<String, Integer> counterScores = new HashMap<>();

        for (String hero : heroCounters.keySet()) {
            int score = 0;
            for (String enemy : enemyTeam) {
                Map<String, List<String>> counters = heroCounters.get(hero);
                for (String type : counters.keySet()) {
                    if (counters.get(type).contains(enemy)) {
                        score++;
                    }
                }
            }
            counterScores.put(hero, score);
        }

        return counterScores.entrySet().stream()
                            .max(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .orElse("No effective counter found");
    }

    public static void main(String[] args) {
        HeroCounterData converter = new HeroCounterData("res/hero_data.csv");
        Map<String, Map<String, List<String>>> data = converter.convertCSVToMap();
        HeroCounterPicker strategy = new HeroCounterPicker(data);
        List<String> enemyTeam = Arrays.asList("Orisa", "Junkrat", "Pharah", "Ana", "Moira");
        String bestHero = strategy.findBestCounterHero(enemyTeam);
        System.out.println("Best hero to counter the given team: " + bestHero);
    }
}