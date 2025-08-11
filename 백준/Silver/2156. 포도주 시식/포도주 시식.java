import java.io.*;

public class Main {

    static int[] dp, wine;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        dp = new int[N];
        wine = new int[N]; 

        for(int i=0; i<N ; i++){
            wine[i] = Integer.parseInt(br.readLine().trim());
        }

        //초기
        if(N==1){
            ans = wine[0];
            bw.write(String.valueOf(ans));
            bw.flush();
            return;
        }
        dp[0] = wine[0];

        if(N==2){
            ans = wine[0] + wine[1];
            bw.write(String.valueOf(ans));
            bw.flush();
            return;
        }
        dp[1] = wine[0] + wine[1];
        dp[2] = ans = Math.max((Math.max(wine[0], wine[1]) + wine[2]), dp[1]);

        for(int i=3 ; i<N ; i++){
            dp[i] = Math.max((Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i]),dp[i-1]);
        }
        bw.write(String.valueOf(dp[N-1]));
        bw.flush();
        bw.close();

    }
}