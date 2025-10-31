import java.io.FileWriter;
import java.io.IOException;

public class CsvResults {

    private FileWriter writer;

    private CsvResults(String fileName) {
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            System.err.println("Error opening csv file!");
        }

    }

}
