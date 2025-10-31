import java.io.FileWriter;
import java.io.IOException;

public class CsvResults {

    private FileWriter writer;

    public CsvResults(String fileName) {
        try {
            writer = new FileWriter(fileName);
            writer.write("iteration,heuristic_cost,test_case\n");

        } catch (IOException e) {
            System.err.println("Error opening the csv file!");
        }

    }

    public void enterResults(int iteration, int heuristic, int testCase) {
        try {
            writer.write(iteration + "," + heuristic + "," + testCase + "\n");
        } catch (IOException e) {
            System.err.println("Error writing into the csv file!");
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Error closing the file!");
        }
    }

}
