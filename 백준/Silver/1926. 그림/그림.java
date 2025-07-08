import java.io.*;
import java.util.*; 

public class Main{

    static int n,m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int pCount = 0;
    static int mCount = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine());
        n = input[0];
        m = input[1];
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n ; i++){
            grid[i] = sToIArr(br.readLine().trim());
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0; j<m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                }
            }
        }

        bw.write(pCount +"\n" + mCount);

        bw.flush(); 
        bw.close();
    }

    static void dfs(int sx, int sy){
        Stack<int[]> s = new Stack<>();
        int cCount = 0;

        s.push(new int[]{sx,sy});
        visited[sx][sy] = true; 

        while(!s.isEmpty()){
            int[] cur = s.pop();
            int cx = cur[0], cy  = cur[1];
            cCount++;

            for(int d=0; d<4 ; d++){
                int nx = cx + dx[d], ny = cy+dy[d];

                if( nx>= 0 && nx < n && ny>=0 && ny<m &&
                    grid[nx][ny] == 1 && !visited[nx][ny]){
                        s.push(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
            }

        }

        if(cCount > mCount){
            mCount = cCount;
        }

        pCount++;
    }

    

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
   
}
