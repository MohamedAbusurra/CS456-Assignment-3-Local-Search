public class HillClimbingAlgorithm {

    private int[] state;
    int n;

    public HillClimbingAlgorithm(int[] queens) {
        System.out.println("testing hill climbing algorithm");
        this.state = queens;
        this.n = queens.length;
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

    private int[] getNeighbor(int[] state) {
        int[] NeighborState = new int[n];

        return NeighborState;
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

            currentState = getNeighbor(currentState);

        }

    }

}