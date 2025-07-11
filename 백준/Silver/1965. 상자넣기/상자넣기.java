import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static int[] box;
    static int[] d;
    static int max = 1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine().trim());
        box = sToIArr(br.readLine());
        d = new int[n];
        Arrays.fill(d,1);

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if(box[i] > box[j]){
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            max = Math.max(max, d[i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
