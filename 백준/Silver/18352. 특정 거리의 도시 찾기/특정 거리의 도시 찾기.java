import java.io.*;
import java.util.*;

public class Main{

    static int N,M,K,X;
    static int[] dist; // 출발 노드로 부터 최단거리
    static ArrayList<Edge>[] graph; // 인접 그래프

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        N = input[0];  // 도시 개수
        M = input[1];  // 도로 개수
        K = input[2];  // 거리 정보
        X = input[3];  // 출발 도시 번호

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1 ; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            int[] startend = sToIArr(br.readLine().trim());
            int start = startend[0];
            int end = startend[1];
            graph[start].add(new Edge(end,1));
        }

        // 출발도시
        dist[X] = 0;
        // 다익스트라
        dijkstra();

        int ans = 0;
        for(int i=0 ; i<dist.length;i++){
            if(dist[i] == K){
                bw.write(String.valueOf(i)+"\n");
                ans++;
            }
        }

        if(ans==0) bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();

    }

    // 다익스트라
    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(X,0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int vertex = edge.vertex;
            int cost = edge.cost;
            
            if(dist[vertex] < cost){
                continue;
            }
            
            for(int i=0; i< graph[vertex].size(); i++){
                int nxtVtx = graph[vertex].get(i).vertex;
                int nxtCost = graph[vertex].get(i).cost + cost;
                if(dist[nxtVtx] > nxtCost){
                    dist[nxtVtx] = nxtCost;
                    pq.add(new Edge(nxtVtx, nxtCost));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost){
            this.vertex = vertex; 
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return cost - o.cost;
        }

    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    } 
}
