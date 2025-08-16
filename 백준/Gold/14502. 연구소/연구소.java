import java.io.*;
import java.util.*;

public class Main{

    static int N,M;
    static int[][] graph;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Idx> blank = new ArrayList<>();
    static ArrayList<Idx> virus = new ArrayList<>();
    static int infCnt;
    static int maxCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        N = input[0];
        M = input[1];


        graph = new int[N][M];
        for(int i=0; i<N ; i++){
            graph[i] = sToIArr(br.readLine());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M ; j++){
                if(graph[i][j] == 2){
                    virus.add(new Idx(i,j));
                }
                if(graph[i][j] == 0){
                    blank.add(new Idx(i,j));
                }
            }
        }


        // 빈 벽 3개 조합 찾기
        for(int i =0 ; i < blank.size(); i++){
            for(int j=i+1; j<blank.size(); j++){
                for(int k= j+1 ; k<blank.size();k++){
                    // 원본 맵 카피해두기
                    int[][] map = copyOf(graph);

                    map[blank.get(i).x][blank.get(i).y] = 1;
                    map[blank.get(j).x][blank.get(j).y] = 1;
                    map[blank.get(k).x][blank.get(k).y] = 1;

                    // 바이러스 위치부터 돌면서 오염시키기 cnt 세기
                    int infected = bfs(map);
                    int bCnt = blank.size() - 3 -  infected;
                    if(maxCnt < bCnt){
                        maxCnt = bCnt;
                    }

                }
            }
            
        }

        bw.write(String.valueOf(maxCnt));
        bw.flush();
        bw.close();
    
    }

    static int[][] copyOf(int[][] src){
        int[][] dst = new int[N][M];
        for (int i=0;i<N;i++) System.arraycopy(src[i], 0, dst[i], 0, M);
        return dst;
    }

    static int bfs(int[][] map){
        Queue<Idx> q = new LinkedList<>();
        for(Idx v:virus) q.offer(v);
        int infected = 0;

        while(!q.isEmpty()){
            Idx cur = q.poll();
            for(int d=0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M 
                     && map[nx][ny] == 0 ){
                        map[nx][ny]= 2;
                        infected++;
                        q.offer(new Idx(nx,ny));
                     }
            }
        }

        return infected;
    }

    static class Idx{
        int x;
        int y;

        public Idx(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
