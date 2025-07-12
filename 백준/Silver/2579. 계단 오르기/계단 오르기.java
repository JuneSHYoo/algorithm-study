import java.io.*;

// BOJ 계단 오르기
public class Main{

    static int[] d;
    static int[] steps;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        steps = new int[n];
        d = new int[n];
       

        for(int i=0 ; i<n ; i++){
            steps[i] = Integer.parseInt(br.readLine().trim());
        }
        
        if(n==1) {
            bw.write(String.valueOf(steps[0]));
            bw.flush();
            bw.close();
            return;
        }
        if(n==2) {
            d[1] = Math.max(steps[0]+steps[1],steps[1]);
            bw.write(String.valueOf(d[1]));
            bw.flush();
            bw.close();
            return;
        }

        if(n==3) {
            d[2] = Math.max(steps[0]+ steps[2], steps[1]+steps[2]);
            bw.write(String.valueOf(d[2]));
            bw.flush();
            bw.close();
            return;
        }

         d[0] = steps[0];
         d[1] = Math.max(d[0]+steps[1],steps[1]);
         d[2] = Math.max(steps[0]+ steps[2], steps[1]+steps[2]);

        for(int i=3 ; i<n ; i++){
            d[i] = Math.max( d[i-3] + steps[i-1] + steps[i],d[i-2] + steps[i]);
        }

        bw.write(String.valueOf(d[n-1]));

        bw.flush();
        bw.close();



    }
}
