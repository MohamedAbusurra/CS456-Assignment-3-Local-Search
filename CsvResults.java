import java.io.FileWriter;
import java.io.IOException;

public class CsvResults {

    private FileWriter writer;

    private CsvResults(String fileName) {
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            System.err.println("Error opening the csv file!");
        }

    }

    public void enterResults(int iteration, int heuristic, String testCase, String algorithm) {
        try {
            writer.write(iteration + "," + heuristic + "," + testCase + "," + algorithm + "\n");
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
