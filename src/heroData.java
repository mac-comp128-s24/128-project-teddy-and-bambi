import java.util.*;
import java.util.HashMap;
public class heroData {

    private static HashMap<String,ArrayList<String>> heroCounter = new HashMap<>();
    private ArrayList<String> dva;
    private ArrayList<String> doomfist;
    private ArrayList<String> junkerqueen;
    private ArrayList<String> mauga;
    private ArrayList<String> orisa;
    // private ArrayList<String> ramattra;
    // private ArrayList<String> reinhardt;
    // private ArrayList<String> roadhog;
    // private ArrayList<String> sigma;
    // private ArrayList<String> winston;
    // private ArrayList<String> wreckingball;
    // private ArrayList<String> zarya;
    // private ArrayList<String> ashe;
    // private ArrayList<String> bastion;
    // private ArrayList<String> cassidy;
    // private ArrayList<String> echo;
    // private ArrayList<String> genji;
    // private ArrayList<String> hanzo;
    // private ArrayList<String> junkrat;
    // private ArrayList<String> mei;
    // private ArrayList<String> pharah;
    // private ArrayList<String> reaper;
    // private ArrayList<String> sojourn;
    // private ArrayList<String> soldier76;
    // private ArrayList<String> sombra;
    // private ArrayList<String> symettra;
    // private ArrayList<String> torbjorn;
    // private ArrayList<String> tracer;
    // private ArrayList<String> widowmaker;
    // private ArrayList<String> ana;
    // private ArrayList<String> baptiste;
    // private ArrayList<String> briggite;
    // private ArrayList<String> illari;
    // private ArrayList<String> kiriko;
    // private ArrayList<String> lifeweaver;
    // private ArrayList<String> lucio; 
    // private ArrayList<String> mercy;
    // private ArrayList<String> moira;
    // private ArrayList<String> zenyatta;

    public heroData(){
      dva = new ArrayList<>();
      dva.add("zarya");
      dva.add("winston");
      dva.add("symmetra");
      dva.add("sojourn");
      dva.add("moira");
      heroCounter.put("dva",dva);
      doomfist = new ArrayList<>();
      doomfist.add("sombra");
      doomfist.add("genji");
      doomfist.add("bastion");
      doomfist.add("tracer");
      doomfist.add("ana");
      doomfist.add("briggitte");
      heroCounter.put("doomfist", doomfist);
      junkerqueen = new ArrayList<>();
      junkerqueen.add("widowmaker");
      junkerqueen.add("wreckingball");
      junkerqueen.add("ana");
      junkerqueen.add("lucio");
      junkerqueen.add("kiriko");
      heroCounter.put("junkerqueen", junkerqueen);
      mauga = new ArrayList<>();
      mauga.add("doomfist");
      mauga.add("wreckingball");
      mauga.add("sombra");
      mauga.add("zenyatta");
      mauga.add("kiriko");
      heroCounter.put("mauga", mauga);
      orisa = new ArrayList<>();
      orisa.add("zarya");
      orisa.add("dva");
      orisa.add("mei");
      orisa.add("echo");
      orisa.add("moira");
      heroCounter.put("orisa",orisa);
    }
   public static ArrayList<String> getCounters(String enemy){
        return heroCounter.get(enemy);
   }

}