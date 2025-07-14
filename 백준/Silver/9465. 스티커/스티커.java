import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] d;
    static int[][] stickers;
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        while(T-->0){

            int n = Integer.parseInt(br.readLine().trim());
            int[][] stickers = new int[3][n+1];
            int[][] d        = new int[3][n+1];

            //  입력 채우기 (index 1~n)
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                stickers[1][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                stickers[2][j] = Integer.parseInt(st.nextToken());
            }
            // 초기값
            d[1][1] = stickers[1][1];
            d[2][1] = stickers[2][1];
            for(int j=2; j<=n;j++){
                int tbmax = Math.max(d[1][j-2],d[2][j-2]) ;
                d[1][j] = Math.max( d[2][j-1] + stickers[1][j] , tbmax + stickers[1][j] );
                d[2][j] = Math.max( d[1][j-1] + stickers[2][j], tbmax + stickers[2][j]);
            }

            int ans = Math.max(d[1][n],d[2][n]);
            bw.write(String.valueOf(ans) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
