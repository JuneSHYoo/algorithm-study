import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Math.abs(a) != Math.abs(b) ? Math.abs(a) - Math.abs(b) : a - b
        );

        int N = Integer.parseInt(br.readLine().trim());

        while(N-->0){
            int x = Integer.parseInt(br.readLine().trim());
            if(x!=0){
                pq.add(x);
            }else{
                if(pq.isEmpty()){
                    bw.write(String.valueOf(0+"\n"));
                }else {
                    int num = pq.poll();
                    bw.write(String.valueOf(num)+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
    
}
