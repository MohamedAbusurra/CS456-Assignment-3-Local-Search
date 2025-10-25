import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        String queenPositions = "";
        int[] queenPositionsArray = new int[8];
        String[] givenQueenPositionInput = { "12375643",
                "13572063",
                "13572064",
                "11111111",
                "40057263" };

        do {

            System.out.println("Choose an option ");
            System.out.println("1.Enter queen position input configuration manually");
            System.out.println("2.Choose one of the given queen position input configurations");
            System.out.print("option: ");
            option = scanner.nextInt();
            scanner.nextLine();

        } while (option != 1 && option != 2);

        if (option == 1) {

            do {
                System.out.print("Enter starting queen position configuration: ");
                queenPositions = scanner.nextLine();
            } while (queenPositions.length() != 8);

            String[] queenPositionsStringArray = queenPositions.split("");

            for (int i = 0; i < 8; i++) {
                queenPositionsArray[i] = Integer.parseInt(queenPositionsStringArray[i]);
            }

        }

        if (option == 2) {
            int startingOption;
            do {
                System.out.println("Choose one of the five given input boards");
                for (int i = 0; i < givenQueenPositionInput.length; i++) {
                    System.out.println((i + 1) + "." + givenQueenPositionInput[i]);
                }

                System.out.print("Choice: ");
                startingOption = scanner.nextInt();

            } while (startingOption < 1 || startingOption > 5);

            queenPositions = givenQueenPositionInput[startingOption - 1];
            String[] queenPositionsStringArray = queenPositions.split("");

            for (int i = 0; i < 8; i++) {
                queenPositionsArray[i] = Integer.parseInt(queenPositionsStringArray[i]);
            }

        }

        while (true) {
            System.out.println();
            System.out.println("Choose an option");
            System.out.println("1.Perform Hill Climbing Search");
            System.out.println("2.Perform Simluated Annealing Search");
            System.out.println("3.Exit");
            System.out.print("Enter number for option chosen: ");
            option = scanner.nextInt();

            if (option == 3)
                break;

            if (option != 1 && option != 2) {
                System.out.println("invalid option entered!");
                continue;
            }

            System.out.print("enter a Random seed: ");
            int seed = scanner.nextInt();

            if (option == 1) {
                HillClimbingAlgorithm hillclimbingAlgorithm = new HillClimbingAlgorithm(queenPositionsArray, seed);
                hillclimbingAlgorithm.performHillClimbingSearch();
            } else if (option == 2) {
                SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm = new SimulatedAnnealingAlgorithm(
                        queenPositions, seed);
                simulatedAnnealingAlgorithm.solve();
            }
        }

        scanner.close();

    }
}