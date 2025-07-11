import java.io.*;
import java.util.*;

public class Main{
    static int[] p;
    static int[] d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        d = new int[n+1];
        p = sToIArr(br.readLine());

        Arrays.fill(d,0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j] + p[j-1]);
            }
        }

        bw.write(String.valueOf(d[n]));
        bw.flush();
        bw.close();
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
