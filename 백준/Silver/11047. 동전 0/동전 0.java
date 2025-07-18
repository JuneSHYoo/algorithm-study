import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        int N = input[0];
        int K = input[1];
        int[] a = new int[N];

        for(int i=0; i<N ; i++){
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int cnt = 0;
        for(int i=N-1; i>=0;i--){
            if(a[i] <= K){
                cnt += K / a[i];
                K %= a[i];
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}