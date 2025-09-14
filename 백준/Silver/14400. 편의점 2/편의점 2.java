import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] custX;
    static int[] custY;
     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        custX = new int[n];
        custY = new int[n];

        for(int i=0;i<n;i++){
            int[] input = sToIArr(br.readLine());
            custX[i] = input[0];
            custY[i] = input[1];
        }

        Arrays.sort(custX);
        Arrays.sort(custY);

        int x = custX[n/2] ,y = custY[n/2];

        long dist = 0;
        for(int i = 0; i<n ; i++){
            dist += Math.abs(custX[i] - x) + Math.abs(custY[i]-y);
        }
        System.out.print(dist);
        System.out.print("\n");


    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }


}