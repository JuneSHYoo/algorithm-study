import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static int n, ans;
    static int del;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=0 ; i<n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        //입력받기
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){ // 노드가 0번부터 시작
            int node = Integer.parseInt(st.nextToken());
            if(node == -1){
                root = i;
            }else{
                graph[i].add(node);
                graph[node].add(i);
            }
        }

        del = Integer.parseInt(br.readLine());

        if(del == root){
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close(); 
            return;
        }else dfs(root);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    static void dfs(int r){
        visited[r] = true;
        int child = 0;
        for(int cur : graph[r]){
            if(cur != del && !visited[cur]){
                child++;
                dfs(cur);
            }
        }
        if(child ==0){
            ans++;
        }
    }
}
