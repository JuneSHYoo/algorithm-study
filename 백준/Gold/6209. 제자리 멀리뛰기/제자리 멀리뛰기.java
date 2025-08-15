import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = sToIArr(br.readLine().trim());
        int d = input[0];
        int n = input[1]; 
        int m = input[2];

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(d);
        for(int i=0; i<n;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int left = 1;
        int right = d;
        int answer = 0;

        while(left<=right){
            int mid = (left+right) /2;
            int cur = arr.get(0);
            int rmvCnt = 0;

            for(int i=1; i<=n; i++){
                int diff = arr.get(i) - cur;

                if(diff < mid) {
                    rmvCnt++;
                }else{
                    cur = arr.get(i);
                }
            }

            if(rmvCnt <= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}
