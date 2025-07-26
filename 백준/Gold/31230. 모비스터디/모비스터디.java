import java.io.*;
import java.util.*;

public class Main{

    static int N,M,A,B;
    static ArrayList<Edge>[] map;
    static long[][] distance;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        N = input[0];
        M = input[1];
        A = input[2];
        B = input[3];

        distance = new long[2][N+1];
        for(int i=0;i<2;i++){
            Arrays.fill(distance[i],Long.MAX_VALUE);
        }
        map = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M ; i++){
            int[] inp = sToIArr(br.readLine());
            int a = inp[0];
            int b = inp[1];
            long c = inp[2];

            map[a].add(new Edge(b,c));
            map[b].add(new Edge(a,c));
        }

        // A 부터 시작
        distance[0][A] = 0;
        dijkstra(0,A);

        // B 부터 시작
        distance[1][B] = 0;
        dijkstra(1,B);

        // 흠 
        long minDist = distance[0][B];
        ans = new ArrayList();

        for(int i=1; i<=N ; i++){
            if( distance[0][i]+ distance[1][i] == minDist){
                ans.add(i);
            }
        }

        //[[9223372036854775807, 0, 4, 3, 1, 2, 7, 2]. a가 i까지 가는 비용
        // [9223372036854775807, 7, 3, 5, 6, 5, 0, 5]] b가 i까지 가는 비용



        bw.write(String.valueOf(ans.size())+ "\n");
        for(int i : ans){
            bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
        bw.close();



    }

    private static void dijkstra(int idx, int st){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(st,0L));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int pos = cur.pos; 
            long dist = cur.dist;

            if(dist > distance[idx][pos]) continue;

            for(Edge e : map[pos]){
                int npos = e.pos;
                long ndist = dist + e.dist;

                if(ndist < distance[idx][npos]){
                    distance[idx][npos] = ndist;
                    pq.offer(new Edge(npos, ndist));
                }
            }
        }


    
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static class Edge implements Comparable<Edge>{
        int pos; 
        Long dist;

        public Edge(int pos, Long dist){
            this.pos = pos;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o){
            return Long.compare(this.dist, o.dist);
        }


    }


}
