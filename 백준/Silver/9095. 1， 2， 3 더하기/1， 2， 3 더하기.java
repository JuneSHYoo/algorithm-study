import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        

        for(int i=0; i < t ; i++){
            int n = Integer.parseInt(br.readLine().trim());
            int len = Math.max(n+1, 4);
            int[] d = new int[len];
            int a = xby123(n,d);

            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int xby123(int n,int[] d){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        // 초기
        d[1] = 1;
        d[2] = 2; 
        d[3] = 4;

        for(int i = 4 ; i <= n ; i++){
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        return d[n];
    }
    
}
