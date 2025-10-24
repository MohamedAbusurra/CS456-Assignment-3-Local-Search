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
    int t = 100;
    int h_old = h(queen);
    while(true){
        Random random = new Random(seed);
        Random random2 = new Random(seed);
        int col = random.nextInt(8);
        int row = random2.nextInt(8);

    }
   }
}