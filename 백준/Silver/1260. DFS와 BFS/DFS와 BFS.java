import java.io.*;
import java.util.*;

public class Main{

    static int N,M,V;
    static ArrayList<Integer>[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        N = input[0];
        M = input[1];
        V = input[2];

        arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            int[] link = sToIArr(br.readLine());
            arr[link[0]].add(link[1]);
            arr[link[1]].add(link[0]);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }

        dfs(V);
        System.out.print("\n");
        bfs(V);

        bw.flush();
        bw.close();

    }

    static void dfs(int root){
        boolean[] visited = new boolean[N+1];
        Stack<Integer> s = new Stack<>();

        s.push(root);

        while(!s.isEmpty()){
            int cur = s.pop();

            if(visited[cur]) continue;

            visited[cur] = true;
            System.out.print(cur + " ");

            for (int i = arr[cur].size() - 1; i >= 0; i--){
                int nxt = arr[cur].get(i);
                if (!visited[nxt]){
                    s.push(nxt);
                }
            }
        }
    }

    static void bfs(int root){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(visited[cur]) continue;

            visited[cur] = true;
            System.out.print(cur + " ");

            for(int nxt : arr[cur]){
                if(!visited[nxt]){
                    q.offer(nxt);
                }
            }
        }
        
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
