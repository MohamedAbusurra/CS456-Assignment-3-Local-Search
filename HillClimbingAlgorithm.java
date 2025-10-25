import java.util.ArrayList;
import java.util.Random;

public class HillClimbingAlgorithm {

    private int[] state;
    int n;
    Random randomlySelectMoveOut;
    int seed;

    public HillClimbingAlgorithm(int[] queens, int seed) {
        this.state = queens;
        this.n = queens.length;
        this.seed = seed;
        this.randomlySelectMoveOut = new Random(seed);

    }

    private int calculateHeuristic(int[] state) {
        int heuristic = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (state[i] == state[j])
                    heuristic++;
                if (Math.abs(state[i] - state[j]) == Math.abs(i - j))
                    heuristic++;
            }
        }

        return heuristic;
    }

    private void printBoard(int[] state) {
        for (int i = 0; i < n; i++) {
            System.out.print(state[i]);
        }
    }

    private int[] getNeighbor(int[] state, int heuristic) {
        int lowestHeuristicFound = heuristic;
        ArrayList<int[]> possibleStates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int originalQueenpositionInColumn = state[i];

            for (int j = 0; j < n; j++) {
                if (originalQueenpositionInColumn == j)
                    continue;

                int[] testNeighborState = copyBoard(state);
                testNeighborState[i] = j;
                int neighborHeuristic = calculateHeuristic(testNeighborState);

                if (neighborHeuristic < lowestHeuristicFound)
                    lowestHeuristicFound = neighborHeuristic;
            }
        }

        for (int i = 0; i < n; i++) {
            int originalQueenpositionInColumn = state[i];

            for (int j = 0; j < n; j++) {
                if (originalQueenpositionInColumn == j)
                    continue;

                int[] possibleNeighborState = copyBoard(state);
                possibleNeighborState[i] = j;
                int neighborHeuristic = calculateHeuristic(possibleNeighborState);

                if (neighborHeuristic == lowestHeuristicFound)
                    possibleStates.add(possibleNeighborState);
            }
        }

        if (possibleStates.size() == 0)
            return null;

        int randomIndex = randomlySelectMoveOut.nextInt(possibleStates.size());
        return possibleStates.get(randomIndex);

    }

    private int[] copyBoard(int[] state) {
        int[] copyBoard = new int[n];
        for (int i = 0; i < n; i++)
            copyBoard[i] = state[i];
        return copyBoard;
    }

    public void performHillClimbingSearch() {
        int[] currentState = copyBoard(state);
        int step = 0;
        int currentStateHeuristic;

        System.out.println();
        System.out.println("Hill Climbing Search with " + seed + " as random generator seed");

        while (true) {
            currentStateHeuristic = calculateHeuristic(currentState);

            System.out.print(step + ": ");
            printBoard(currentState);
            System.out.println(" " + currentStateHeuristic);

            if (currentStateHeuristic == 0) {
                System.out.println("Solved");
                break;
            }

            currentState = getNeighbor(currentState, currentStateHeuristic);

            if (currentState == null) {
                System.out.println("Stuck");
                break;
            }

            step++;

        }

    }

}