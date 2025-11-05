import java.util.Random;

class SimulatedAnnealingAlgorithm {
    private String queen;
    private Random random;
    private int max_iteritor = 500;
    private CsvResults csv;

    public SimulatedAnnealingAlgorithm(String queen, int seed, CsvResults csv) {
        this.queen = queen;
        this.random = new Random(seed);
        this.csv = csv;
    }

    public SimulatedAnnealingAlgorithm(String queen, int seed, CsvResults csv, int max_iteritor) {
        this.queen = queen;
        this.random = new Random(seed);
        this.csv = csv;
        this.max_iteritor = max_iteritor;
    }

    private int calculateHeuristic(String queen) {
        int heuristic = 0;
        int n = 8;
        int[] state = new int[queen.length()];

        for (int i = 0; i < queen.length(); i++) {
            state[i] = queen.charAt(i) - '0';
        }
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

    private void print_result(int it, String queen, int h, double t) {
        System.out.println(it + ": " + queen + "  h = " + h + "  T= " + t);
        if (h == 0) {
            System.out.println("solved");
        }
        if (it == max_iteritor - 1) {
            System.out.println("max iterations reached");
        }
    }

    private boolean accept(double p) {
        double u = random.nextDouble();
        if (u < p) {
            return true;
        } else {
            return false;
        }
    }

    private char tochar(int row) {
        return (char) (row + '0');
    }

    public void solve() {
        int it = 0;
        double t = 100;
        int h_old = calculateHeuristic(queen);
        char[] arr = queen.toCharArray(); // all work in this array (updated always (rerendiring))
        print_result(it++, queen, h_old, t);
        csv.enterResults(it, null, h_old);
        if (h_old == 0) {
            return;
        }
        while (t > 0) {
            int col = random.nextInt(8);
            int row = random.nextInt(8);
            t = t * 0.95;
            char old_row = arr[col]; // it used only for backtracking if p not accpet it
            arr[col] = tochar(row);
            String text = new String(arr);
            int h_new = calculateHeuristic(text);
            print_result(it++, text, h_new, t);
            csv.enterResults(it, null, h_new);
            if (h_new == 0) {
                return;
            }
            if (it == max_iteritor) {
                return;
            }
            int E = h_new - h_old;
            if (E > 0) {
                double x = (-E) / t;
                double p = Math.exp(x);
                if (accept(p)) {
                    h_old = h_new;
                } else {
                    arr[col] = old_row; // if its not accepted back to old rerdender (backtracking)
                }

            } else {
                h_old = h_new;
            }

        }
    }
}