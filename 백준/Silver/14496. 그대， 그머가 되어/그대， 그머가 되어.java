import java.io.*;
import java.util.*;

public class Main{

    static int a,b,N,M;
    static ArrayList<Edge>[] graph; 
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input1 = sToIArr(br.readLine());
        int[] input2 = sToIArr(br.readLine());
        a = input1[0];
        b = input1[1];
        N = input2[0];
        M = input2[1];

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int[] input = sToIArr(br.readLine());
            int s = input[0];
            int e = input[1]; 

            graph[s].add(new Edge(e, 1));
            graph[e].add(new Edge(s,1));
        }

        dist[a] = 0;
        dijkstra();


        int ans = dist[b] == Integer.MAX_VALUE ? -1 : dist[b];
        
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();


    }
    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(a,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int pos = cur.pos;
            int cdist = cur.dist;

            if(cdist > dist[pos]) continue;

            for(Edge edge : graph[pos]){
                int nextPos = edge.pos;
                int nextDist = cdist + 1;

                if(nextDist < dist[nextPos]){
                    dist[nextPos] = nextDist;
                    pq.offer(new Edge(nextPos, nextDist));
                }
            }
        }


    }

    private static class Edge implements Comparable<Edge>{
        int pos;
        int dist;

        public Edge(int pos, int dist){
            this.pos = pos;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge o){
            return dist - o.dist;
        }
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}
