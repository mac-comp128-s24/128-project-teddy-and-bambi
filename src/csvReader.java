import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvReader {
    private String path;

    public csvReader(String path) {
        this.path = path;
    }

    public List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(","); // Assuming no commas are quoted
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return data;
    }

    public static void main(String[] args) {
        csvReader reader = new csvReader("/Users/trinhnguyen/Documents/GitHub/128-project-teddy-and-bambi/res/hero_data.csv");
        List<String[]> data = reader.readCSV();
        
        // Print the data to check
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
