import java.io.*;
import java.util.*;
public class Main {

    static int N, d, k, c;
    static int maxCnt = 0;
    static int[] sushi;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 받기
        int[] input = sToIArr(br.readLine());
        N = input[0];
        d = input[1];
        k = input[2];
        c = input[3];
        
        // 스시 초밥 받기
        sushi = new int[N];
        for(int i=0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            boolean[] ate = new boolean[d+1];
            ate[c] = true;
            int cnt = 1; // 초밥 쿠폰으로 먹을수 있는거 미리 세놓기
            for(int j=i; j<k+i; j++){
                if(j >= N){
                    if(!ate[sushi[j-N]] && sushi[j-N] != c) {
                        ate[sushi[j-N]] = true;
                        cnt++;
                    }
                }else{
                    if(!ate[sushi[j]] && sushi[j] != c) {
                        ate[sushi[j]] = true;
                        cnt++;
                    }

                }
            
            }
            if(maxCnt < cnt){
                maxCnt = cnt;
            }

        }
        
        bw.write(String.valueOf(maxCnt));
        bw.flush();
        bw.close();
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
