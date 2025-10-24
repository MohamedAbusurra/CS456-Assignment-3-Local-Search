import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter starting queen position configuration: ");
        Scanner scanner = new Scanner(System.in);

        String[] queenInputConfiguration = scanner.nextLine().split(" ");
        int[] queenPositionArray = new int[queenInputConfiguration.length];

        for (int i = 0; i < queenInputConfiguration.length; i++) {
            queenPositionArray[i] = Integer.parseInt(queenInputConfiguration[i]);
            System.out.println(queenPositionArray[i]);
        }

    }
}