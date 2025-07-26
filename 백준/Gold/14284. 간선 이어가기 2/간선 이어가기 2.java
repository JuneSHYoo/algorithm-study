import java.io.*;
import java.util.*;

public class Main{

    static int n,m,s,t;
    static int[] dist;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력
        int[] input = sToIArr(br.readLine());
        n = input[0];
        m = input[1];

        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++){
            int[] abc = sToIArr(br.readLine());
            int a = abc[0];
            int b = abc[1];
            int c = abc[2];

            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }

        int[] startend =  sToIArr(br.readLine());
        s = startend[0];
        t = startend[1];

        // 초기값
        dist[s] = 0;

        // 다익스트라
        dijkstra();

        bw.write(String.valueOf(dist[t]));
        bw.flush();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int pos = cur.pos;
            int cost = cur.cost;

            if(cost > dist[pos]) continue;

            for(Edge edge : graph[pos]){
                int nxtPos = edge.pos;
                int nxtCost = cost + edge.cost;

                if(nxtCost < dist[nxtPos]){
                    dist[nxtPos] = nxtCost;
                    pq.offer(new Edge(nxtPos, nxtCost));
                }
            }
        }

        
    }

    

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static class Edge implements Comparable<Edge>{
        int pos;
        int cost;

        public Edge(int pos, int cost){
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return cost - o.cost;
        }

    }
    
}
