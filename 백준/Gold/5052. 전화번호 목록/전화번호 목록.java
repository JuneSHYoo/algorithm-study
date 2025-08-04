import java.io.*;
import java.util.*;

public class Main {

    static int t, n;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine().trim());

        while(t-->0){
            n = Integer.parseInt(br.readLine().trim());
            arr = new String[n];
            String ans = "YES";
            for(int i=0;i<n;i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            for(int i=0; i<n-1; i++){
                if(arr[i+1].startsWith(arr[i])){
                    ans = "NO";
                    break;
                }
            }
            bw.write(ans+"\n");
        }
        
        bw.flush();
        bw.close();
        
    }
    
}
