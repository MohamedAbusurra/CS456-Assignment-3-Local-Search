import java.util.ArrayList;
import java.util.Random;

public class HillClimbingAlgorithm {

    private int[] state;
    int n;
    int seed;

    public HillClimbingAlgorithm(int[] queens, int seed) {
        System.out.println("testing hill climbing algorithm");
        this.state = queens;
        this.n = queens.length;
        this.seed = seed;

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

    private int[] getNeighbor(int[] state,int heuristic) {
        int[] NeighborState = new int[n];
        int lowestHeuristicFound = heuristic;
        ArrayList<int[]> possibleStates = new ArrayList<>();

        for(int i=0;i<n;i++){
            int[] board = Copyboard(state);

            for(int j=0 ; j<n; j++){

                if (originalQueenpositionInColumn != j and calculateHeuristic(board) < lowestHeuristicFound){
                    lowestHeuristicFound = calculateHeuristic(NeighborState);
                }
            }
        }


        for(int i=0;i<n;i++){
            int[] copyBoard = Copyboard;

            for(int j=0 ; j<n; j++){

                if (calculateHeuristic(board) == lowestHeuristicFound){
                    possibleStates.add(board);
                }
            }
        }


        Random randomlySelectMoveOut = new Random(seed);
        seed++;
        int randomBoundary = possibleStates.size();
        int randomIndex = randomlySelectMoveOut.nextInt(randomBoundary);

        NeighborState = possibleStates.get(randomIndex);

        return NeighborState;
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