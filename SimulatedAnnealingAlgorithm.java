import java.util.Random;

class SimulatedAnnealingAlgorithm{
    private String queen;
    private int seed;

    public SimulatedAnnealingAlgorithm(String queen,int seed){
        this.queen = queen;
        this.seed = seed;
    }

   public int h(String queen){
    char[] arr = queen.toCharArray();
    int hu = 0;
    /// row
    for(int i = 0 ; i<8;i++){
       int row = 0;
      for(int j = 0 ; j<8;j++){
       if(arr[j]==i+'0'){
        row++;
       }
      }
      hu += (row * (row-1)) / 2;
    }

    // diagonal right
    int col = 0;
    while(col!=8){
        int i = 0;
        int j = col;
        int counter = 0;
        while(j!=8){
            if(arr[j]==i+'0'){
                counter++;
            }
            i++;
            j++;
        }
        hu+= (counter * (counter-1)) / 2;
        col++;
    }

    
    // diagonal left
    int col2 = 7;
    while(col2!=-1){
        int i = 0;
        int j = col2;
        int counter = 0;
        while(j!=-1){
            if(arr[j]==i+'0'){
                counter++;
            }
            i++;
            j--;
        }
        hu+= (counter * (counter-1)) / 2;
        col2--;
    }

    return hu;
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
        if(h_new==0){
            /// finish
            /// return
        }
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