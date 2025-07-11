import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[] d = new int[n+1];
        d[1] = 1;

        if(n>=2) d[2] = 2;
        for(int i=3 ; i<=n ; i++){
            d[i] = (d[i-1]+d[i-2])%15746;
        }

        bw.write(String.valueOf(d[n]%15746));
        bw.flush();
        bw.close();
    }
}