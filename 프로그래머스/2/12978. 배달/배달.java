import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<Edge>[] graph;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        graph = new ArrayList[N+1];
        for(int i=1; i<=N ; i++){
            graph[i] = new ArrayList<>();
        }  
        
        for(int i=0; i<road.length ; i++){
            int d = road[i][2];
            graph[road[i][0]].add(new Edge(road[i][1], d));
            graph[road[i][1]].add(new Edge(road[i][0], d));
        }
        
        dist[1] = 0;
        dijkstra();
        
        for(int i=1; i<=N ; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int pos = cur.pos;
            int cost = cur.cost;
            
            if(cost > dist[pos]) continue;
            
            for(Edge e : graph[pos]){
                int nPos = e.pos;
                int nCost = cost + e.cost;
                
                if(nCost < dist[nPos]){
                    dist[nPos] = nCost; 
                    pq.offer(new Edge(nPos,nCost));
                }
            }
        }
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