import java.io.*;
public class Main{

    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        d = new int[n+1];

        int ans = dp(n);

        bw.write(String.valueOf(ans%10007));
        
        bw.flush();
        bw.close();
    }
    
    private static int dp(int n){
        if(n==1) return 1;
        if(n==2) return 2;

        d[1] = 1;
        d[2] = 2;

        for(int i=3; i<=n;i++){
            d[i] = (d[i-1]+d[i-2]) % 10007;
        }

        return d[n];
    }
}
