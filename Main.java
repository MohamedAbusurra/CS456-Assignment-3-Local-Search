import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter starting queen position configuration: ");
        Scanner scanner = new Scanner(System.in);

        String[] queenInputConfiguration = scanner.nextLine().split(" ");
        int[] queenPositionArray = new int[queenInputConfiguration.length];

        for (int i = 0; i < queenInputConfiguration.length; i++) {
            queenPositionArray[i] = Integer.parseInt(queenInputConfiguration[i]);
        }

        while (true) {
            System.out.println("Choose an option");
            System.out.println("1.Perform Hill Climbing Search");
            System.out.println("2.Perform Simluated Annealing Search");
            System.out.println("3.Exit");
            System.out.print("Enter number for option chosen: ");
            int option = scanner.nextInt();

            if (option != 1 && option != 2 && option != 3) {
                System.out.println("invalid option entered!");
                continue;
            }

            System.out.print("enter a Random seed: ");
            int seed = scanner.nextInt();

            if (option == 1) {
                HillClimbingAlgorithm hillclimbingAlgorithm = new HillClimbingAlgorithm(queenPositionArray, seed);
                hillclimbingAlgorithm.performHillCLimbingSearch();
            } else if (option == 2) {
                SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm = new SimulatedAnnealingAlgorithm(null, seed);
                simulatedAnnealingAlgorithm.solve();
            } else
                break;

        }

    }
}