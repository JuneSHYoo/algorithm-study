import java.io.*;
import java.util.*; 

public class Main{
    static int N,D;
    static ArrayList<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        N = input[0];
        D = input[1];

        dist = new int[D+1];
        graph = new ArrayList[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<=D;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N;i++){
            int[] uvw = sToIArr(br.readLine().trim());
            int u = uvw[0];
            int v = uvw[1];
            int w = uvw[2];

            if(v<=D){
                graph[u].add(new Edge(v,w));
            }
        }

        // 출발지
        dist[0] = 0;
        dijkstra();

        bw.write(String.valueOf(dist[D]));
        bw.flush();
        bw.close();

    }

    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int pos = cur.pos;
            int cost = cur.cost;

            if (cost > dist[pos]) continue;

            // 한칸이동
            if( pos+1 <= D && cost+1 < dist[pos+1] ){
                dist[pos+1] = cost+1; 
                pq.add(new Edge(pos+1, cost+1));
            }
            // 지름길이동
            for(Edge edge:graph[pos]){
                int nPos = edge.pos;
                int nCost = cost + edge.cost;
                if(nCost <= dist[nPos]){
                    dist[nPos] = nCost;
                    pq.add(new Edge(nPos, nCost));
                }
            }

        }
    }

    private static class Edge implements Comparable<Edge> {
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

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
