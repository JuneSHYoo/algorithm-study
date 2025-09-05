import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] grid;
    static int maxH = Integer.MIN_VALUE;
    static boolean[][] visited;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for(int i=0; i<N ; i++){
            grid[i] = sToIArr(br.readLine());
        }

        for(int i=0; i<N ; i++){
            for(int j=0; j<N ; j++){
                if(maxH < grid[i][j]){
                    maxH = grid[i][j];
                }
            }
        }

        // 함수 작성하기
        int ans = 0;
        for(int h = 0; h<= maxH ; h++){
            ans = Math.max(ans, countArea(h));
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }
    
    static void dfs(int x , int y , int h){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(grid[nx][ny] <= h) continue;
            dfs(nx, ny, h);
        }
    }

    static int countArea(int h){
        visited = new boolean[N][N];

        int cnt = 0;

        for(int r =0 ; r<N; r++){
            for(int c=0; c<N; c++){
                if(!visited[r][c] && grid[r][c]>h){
                    dfs(r,c,h);
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
