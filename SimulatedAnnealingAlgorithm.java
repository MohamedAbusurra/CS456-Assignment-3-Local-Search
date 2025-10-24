import java.util.Random;

class SimulatedAnnealingAlgorithm {
    private String queen;
    private int seed;

    public SimulatedAnnealingAlgorithm(String queen, int seed) {
        this.queen = queen;
        this.seed = seed;
    }
  
    private int calculateHeuristic(String queen) {
        int heuristic = 0;
        int n = 8;
        int[] state = new int[queen.length()];

        for (int i = 0; i < queen.length(); i++) {
            state[i] = queen.charAt(i) - '0'; // تحويل char → int
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

    public void solve() {
        int it = 0;
        double t = 100;
        int h_old = calculateHeuristic(queen);
        String text = queen;
        char[] arr = text.toCharArray();
        System.out.println(it+": " + queen + "  h = " + h_old + "  T= " + t );
        it++;
        Random random = new Random(seed);
        Random random3 = new Random(seed);
        while (true) {
            int col = random.nextInt(8);
            int row = random.nextInt(8);
            t = t * 0.95;
            char old_row = arr[col]; 
            arr[col] = (char) (row + '0');
            text = new String(arr);
            int h_new = calculateHeuristic(text);
            System.out.println(it+": " + text + "  h = " + h_new + "  T= " + t );
            it++;
            if (h_new == 0) {
                /// finish return
                return;
            }
            int E = h_new - h_old;
            if (E > 0) {
                double x = (-E) / t;
                double p = Math.exp(x);
                double u = random3.nextDouble();
                if (!(u > p)) {
                    h_old = h_new;
                }
                else{
                    arr[col] = old_row;
                }

            }
            else{
                h_old = h_new;
            }

        }
    }
}