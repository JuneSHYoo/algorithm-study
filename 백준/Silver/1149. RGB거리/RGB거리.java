import java.io.*;
import java.util.*;

public class Main{

    static int[][] color;
    static int[][] d;
    static int[] r;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine().trim());
        color = new int[n][3];
        d = new int[n][3];
        r = new int[3];
        for(int i=0 ; i < n; i++){
            color[i] = sToIArr(br.readLine().trim());
        }

        minCost(n);
        
        Arrays.sort(d[n-1]);
        bw.write(String.valueOf(d[n-1][0]));

        bw.flush();
        bw.close();
    }

    static void minCost(int k){
        //초기값
        d[0][0] = color[0][0];
        d[0][1] = color[0][1];
        d[0][2] = color[0][2];

        for(int i=1; i<k ; i++){
            d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + color[i][0];
            d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + color[i][1];
            d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + color[i][2];
        }
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    
}
