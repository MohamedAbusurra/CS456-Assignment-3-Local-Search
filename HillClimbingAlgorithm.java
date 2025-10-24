import java.util.ArrayList;
import java.util.Random;

public class HillClimbingAlgorithm {

    private int[] state;
    int n;
    Random randomlySelectMoveOut;

    public HillClimbingAlgorithm(int[] queens, int seed) {
        System.out.println("testing hill climbing algorithm");
        this.state = queens;
        this.n = queens.length;
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
        int[] neighborState = new int[n];
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

        int randomIndex = randomlySelectMoveOut.nextInt(possibleStates.size());
        neighborState = possibleStates.get(randomIndex);
        return neighborState;
    }

    private int[] copyBoard(int[] state) {
        int[] copyBoard = new int[n];
        for (int i = 0; i < n; i++)
            copyBoard[i] = state[i];
        return copyBoard;
    }

    public void performHillCLimbingSearch() {
        int[] currentState = state;
        int step = 0;

        while (true) {
            int currentStateHeuristic = calculateHeuristic(currentState);

            System.out.print(step + ":");
            printBoard(currentState);
            System.out.println(" " + currentStateHeuristic);

            if (currentStateHeuristic == 0) {
                System.out.print("Solved");
                break;
            }

            currentState = getNeighbor(currentState, currentStateHeuristic);

        }

    }

}