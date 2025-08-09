import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Long M;
    static int[] trees;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        N = input[0];
        M = (long) input[1];
    
        trees = sToIArr(br.readLine().trim());
        int maxH = 0;
        for(int h : trees){
            if(h>maxH) maxH = h;
        }

        // 이분탐색
        long low = 0, high = maxH , ans =0;
        while(low <= high){
            long mid = low + (high-low)/2;
            long cut = 0;

            for(int h:trees){
                if(h>mid) cut += (h-mid); 
                if(cut >=M) break;
            }

            if(cut >= M){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}