import java.util.*;
import java.util.ArrayList; 

public class counterPicker {

    private ArrayList<String> dupeList;
    public counterPicker(){

    }
    public ArrayList<String> findCounter(ArrayList<String> enemyTeam){
        dupeList = new ArrayList<>();
        ArrayList<String> bestCounters = new ArrayList<>();
            for (String enemyHero : enemyTeam){
                for (String counterPicks :heroData.getCounters(enemyHero)){
                    if(!dupeList.contains(counterPicks)){
                        bestCounters.add(counterPicks);
                    }
                    if(dupeList.contains(counterPicks)){
                        dupeList.add(counterPicks);
                    }
                }
            }
        return bestCounters;

    }
}
