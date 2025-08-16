import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] coms;
    static boolean[] visited;
    static int[] cnt;
    static int N,M;
    static int mxCnt;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        N = input[0];
        M = input[1];

        coms = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            coms[i] = new ArrayList<>();
        }
        
        cnt = new int[N+1];
        Arrays.fill(cnt,0);


        for(int i=0;i<M;i++){
            int[] nodes = sToIArr(br.readLine());
            coms[nodes[1]].add(nodes[0]);
        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            bfs(i);
        }

        for(int i=1;i<=N; i++){
            if(cnt[i] == mxCnt){
                bw.write(String.valueOf(i) + " ");
            }
        }
        bw.flush();
        bw.close();

        
    }

    static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        visited[r] = true;
        int rcnt = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : coms[cur]){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    rcnt++;
                    q.offer(nxt);
                }
            }
        }

        if(mxCnt < rcnt){
            mxCnt = rcnt;
        }
        cnt[r] = rcnt;

    }

    static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}
