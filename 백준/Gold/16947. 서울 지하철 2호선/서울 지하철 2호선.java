import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<Integer>[] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        int[] degree = new int[N+1];
        for(int i = 0; i<N ; i++){
            int[] input = sToIArr(br.readLine());
            arr[input[0]].add(input[1]);
            arr[input[1]].add(input[0]);
            degree[input[0]]++;
            degree[input[1]]++;
        }

        // 순환선이 아닌 노드 찾아내기
        // degree가 1인 노드 큐에 넣어주면서 지워주기
        boolean[] nonCircular = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N;i++){
            if(degree[i] == 1) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            nonCircular[cur] = true;
            for(int nxt : arr[cur]){
                if(nonCircular[nxt]) continue;
                degree[nxt]--;
                if(degree[nxt]==1){
                    q.offer(nxt);
                } 
            }
        }

        // 순환선 기준으로 bfs 하면서 거리 계산하기
        int[] dist = new int[N+1];
        Queue<Integer> bfs = new ArrayDeque<>();
        Arrays.fill(dist, -1);
        for(int i=1; i<=N ; i++){
            if(!nonCircular[i]){
                dist[i] = 0;
                bfs.add(i);
            }
        }
        while(!bfs.isEmpty()){
            int now = bfs.poll();
            for(int node : arr[now]){
                if(dist[node] != -1) continue; // ⭐️
                dist[node] = dist[now] + 1;
                bfs.add(node);
            }
        }

        for(int i=1 ; i<=N ; i++){
            bw.write(String.valueOf(dist[i]) + " ");
        }
        bw.flush();
        bw.close();

    }



    static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    
    
}



