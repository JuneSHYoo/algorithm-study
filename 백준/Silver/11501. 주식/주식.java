import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        while(T-->0){
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            arr = sToIArr(br.readLine());

            int maxP = arr[N-1];
            long sum = 0;
            
            for(int i=N-1;i>=0;i--){
                if ( maxP < arr[i] ){
                    maxP = arr[i];
                }else {
                    sum += maxP-arr[i];
                }
            }

            bw.write(String.valueOf(sum)+"\n");
        }

        bw.flush();
        bw.close();

    }
    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}

