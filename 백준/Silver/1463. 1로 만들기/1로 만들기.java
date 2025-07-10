import java.io.*;

public class Main{

    static int[] d;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        
        d = new int[1000001];
        d[1] = 0;

        for(int i=2; i <= n; i++){
            d[i] = d[i-1] + 1;

            if(i%2 ==0){
                d[i] = Math.min(d[i], d[i/2]+1);
            }
            
            if(i%3 == 0){
                d[i] = Math.min(d[i], d[i/3]+1);
            }
        }

        bw.write(String.valueOf(d[n]));

        bw.flush();
        bw.close();
    }
    
}
