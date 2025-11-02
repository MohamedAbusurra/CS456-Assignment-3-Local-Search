import java.io.FileWriter;
import java.io.IOException;

public class CsvResults {
    private FileWriter writer;

    public CsvResults(String fileName) {
        try {
            writer = new FileWriter(fileName);
            writer.write("iteration,hc_heuristic,sa_heuristic\n");
        } catch (IOException e) {
            System.err.println("Error opening the CSV file!");
        }
    }

    public void enterResults(int iteration, Integer hcHeuristic, Integer saHeuristic) {
        try {
            String hc = (hcHeuristic == null) ? "" : String.valueOf(hcHeuristic);
            String sa = (saHeuristic == null) ? "" : String.valueOf(saHeuristic);
            writer.write(iteration + "," + hc + "," + sa + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to the CSV file!");
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Error closing the CSV file!");
        }
    }
}