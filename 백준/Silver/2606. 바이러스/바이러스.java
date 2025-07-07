import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int count = 0 ;

    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        
        arr = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            int[] link = sToIArr(br.readLine());
            arr[link[0]].add(link[1]);
            arr[link[1]].add(link[0]);
        }

        bfs(1);
        
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();

    }

    static void bfs(int root){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        visited[root] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : arr[cur]){
                if(!visited[nxt]){
                    q.offer(nxt);
                    visited[nxt] = true;
                    count++;
                }
            }
        }

    }
    

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
