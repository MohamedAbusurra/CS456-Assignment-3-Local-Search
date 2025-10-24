import java.util.Random;

class SimulatedAnnealingAlgorithm{
    private String queen;
    private int seed;

    public SimulatedAnnealingAlgorithm(String queen,int seed){
        this.queen = queen;
        this.seed = seed;
    }

   public int h(String queen){

    return 0;
   }

   public void solve(){
    double t = 100;
    int h_old = h(queen);
    String text = queen;
    char[] arr = text.toCharArray();
    while(true){
        Random random = new Random(seed);
        Random random2 = new Random(seed);
        int col = random.nextInt(8);
        int row = random2.nextInt(8);
        t = t*0.95;
        arr[col] = (char)(row + '0');
        text = new String(arr);
        int h_new = h(text);
        int E = h_new - h_old;
        if(E>0){
            double x = (-E)/t;
            double p = Math.exp(x);
            Random random3 = new Random(seed);
            double u = random3.nextDouble();
            if(!(u>p)){
                h_old = h_new;
            }

        }

    }
   }
}