import java.io.*; 
import java.util.*;

public class Main{
    static int n,m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1,1,-1,1,-1};  // 대각선
    static int[] dy = {1,-1,0,0,1,-1,-1,1};
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            
            int[] input = sToIArr(br.readLine());
            n = input[0];
            m = input[1];

            if(n==0 && m==0){
                break;
            }
            grid = new int[m][n];
            visited = new boolean[m][n];
            result = 0;

            // n,m 2 이상인 경우

            // grid
            for(int i=0 ; i < m ; i++){
                grid[i] = sToIArr(br.readLine());
            }

            // dfs
            for(int i=0 ; i < m ; i++){
                for(int j=0 ; j < n  ; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                       dfs(i,j);
                       result++;
                    }
                }
            }

            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();

    }

    static void dfs(int sx, int sy){
        List<Integer> answer = new ArrayList<>();
        Stack<int[]> s = new Stack<>();

        s.push(new int[]{sx, sy});
        visited[sx][sy] = true;

        while(!s.isEmpty()){
            int[] cur = s.pop();
            int cx = cur[0] , cy = cur[1];

            for(int d=0 ; d < 8 ; d++){
                int nx = cx + dx[d], ny = cy + dy[d];
                
                if(nx>=0 && nx < m && ny>=0 && ny < n &&
                  grid[nx][ny]==1 && !visited[nx][ny]){
                    s.push(new int[]{nx,ny});
                    visited[nx][ny] = true;
                  }
            }

        }

    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
