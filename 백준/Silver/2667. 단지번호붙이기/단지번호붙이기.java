import java.io.*;
import java.util.*;

// grid [][]
// visited [][]
// dx, dy
// dfs - stack

public class Main{

    static int n;                   // 입력 정수
    static int[][] grid;            // 그리드
    static boolean[][] visited;     // 방문여부
    static int[] dx = {0,0,1,-1};   // x축 방향
    static int[] dy = {1,-1,0,0};   // y축 방향
    static List<Integer> answer = new ArrayList<>(); // 정답

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine().trim());
        grid = new int[n][n];
        visited = new boolean[n][n];

        // 지도 그려주기
        for(int i=0 ; i<n ; i++){
            grid[i] = sToIArr(br.readLine());
        }

        // dfs 
        for(int i=0; i<n ; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    dfs(i,j);
                }
            }
        }

        // bw.write(Arrays.deepToString(grid)); // 내부 배열까지 

        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for(int c : answer){
            bw.write(c + "\n");
        }

        bw.flush();
        bw.close();

    }

    static void dfs(int sx, int sy){
        Stack<int[]> s = new Stack<>();
        int count = 0;

        s.push(new int[]{sx,sy}); // 👀 오잉
        visited[sx][sy] = true;

        while(!s.isEmpty()){
            int[] cur = s.pop();
            int x = cur[0], y = cur[1];
            count++;

            for(int d=0; d<4; d++){
                int nx = x + dx[d] , ny = y + dy[d];

                if( nx >= 0 && nx < n && ny >= 0 && ny < n &&
                    grid[nx][ny] == 1 && !visited[nx][ny]){
                        s.push(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
            }

        }

        answer.add(count);
    }

    private static int[] sToIArr(String s){
        int len = s.length();
        int[] row = new int[len];
        
        for(int i=0; i<len ; i++){
            row[i] = s.charAt(i) - '0';
        }

        return row;
    }

    
}
