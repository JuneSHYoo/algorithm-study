import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            long[] input = sToLArr(br.readLine());

            for(int j=0;j<N;j++){
                pq.offer(input[j]);
            }
        }

        long ans = 0L;
        int idx = (N*N - N) +1;

        while(idx -->0){
            ans = pq.poll();
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }


    static long[] sToLArr(String s){
        return Arrays.stream(s.split(" ")).mapToLong(Long::parseLong).toArray();
    }

    
}
