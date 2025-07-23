import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        int N = input[0];
        int M = input[1];

        int pack = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;

        for(int i=0; i<M ; i++){
            int[] lineP =  sToIArr(br.readLine().trim());
            int p = lineP[0];
            int e = lineP[1];

            pack = Math.min(pack, p);
            one = Math.min(one, e);
        }

        int case1 = (N/6)*pack + (N%6)*one; // 패키지와 낱개로 산 케이스
        int case2 = (N+5)/6*pack; //패키지로만 산 케이스
        int case3 = N*one; // 낱개로만 산 케이스

        int price = Math.min(case1, Math.min(case2, case3));
        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
    }
    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}