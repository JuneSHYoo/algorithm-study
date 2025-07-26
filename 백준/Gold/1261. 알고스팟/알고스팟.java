import java.io.*;
import java.util.*;

public class Main{
    static int M,N;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int[][] map;
    // static boolean[][] visited;
    static int[][] cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input= sToIArr(br.readLine());
        M = input[0];
        N = input[1];

        map = new int[N][M];
        cnt = new int[N][M];
        for(int i=0; i<N ;i++){
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<N ; i++){
            String st = br.readLine();
            for(int j=0; j<st.length(); j++){
                map[i][j] = st.charAt(j) -'0';
            }
        }

        cnt[0][0] = 0;
        sol();

        int ans = cnt[N-1][M-1];
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();



    }

    private static void sol(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y; 
            int desCnt = cur.desCnt;

            if(desCnt > cnt[x][y]) continue;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nxtCnt = desCnt;

                if( nx >=0 && ny>=0 && nx < N && ny < M) {
                    if(map[nx][ny] == 1){
                        nxtCnt +=1;
                    }

                     if(nxtCnt < cnt[nx][ny]){
                        cnt[nx][ny] = nxtCnt;
                        pq.offer(new Edge(nx,ny,nxtCnt));
                    }
                }

               
            }

        }



    }

    private static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int desCnt;

        public Edge(int x, int y, int desCnt){
            this.x = x;
            this.y = y; 
            this.desCnt = desCnt;
        }

        @Override
        public int compareTo(Edge o){
            return desCnt - o.desCnt;
        }
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    
    
}
