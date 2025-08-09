import java.io.*;
import java.util.*;


public class Main {

    static int[][] eggs;
    static int ans,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for(int i=0; i<N ; i++){
            eggs[i] = sToIArr(br.readLine()); 
        }

        dfs(0,0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }
    
    static void dfs(int now, int cnt){
        if(now == N){
            ans = Math.max(ans, cnt);
            return;
        }

        if(eggs[now][0] <= 0){
            dfs(now+1, cnt);
            return;
        }

        boolean hitOnce = false; 
        
        for(int i=0; i<N; i++){
            if(i==now||eggs[i][0]<=0) continue;

            hitOnce = true;

            eggs[i][0] -= eggs[now][1];
            eggs[now][0] -= eggs[i][1];

            int add =0;
            if(eggs[i][0] <=0 ) add++;
            if(eggs[now][0] <= 0) add++;

            dfs(now+1, cnt+add);
            eggs[now][0]+= eggs[i][1];
            eggs[i][0] += eggs[now][1];
        }

        if(!hitOnce){
            dfs(now+1, cnt);
        }

    }
    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}
