import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[] input = new int[n];

        for(int i=0; i<n ; i++){
            input[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(input);
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0 ; i<n; i++){
            // bw.write(String.valueOf(input[i]*(n-i)));
            max = Math.max(max, input[i]*(n-i));
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
