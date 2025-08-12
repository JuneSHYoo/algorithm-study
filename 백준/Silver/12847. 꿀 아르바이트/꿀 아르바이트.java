import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] money;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        n = input[0];
        m = input[1]; 

        money = sToIArr(br.readLine());
        long max = 0;

        for(int i=0; i <= n-m; i++){
            long sum = 0;
            for(int j=i; j<m+i ; j++){
                sum += (long) money[j];
            }
            if(sum > max) {
                max = sum;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();


    }
    
    static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}


/// n 일급  M  n+1