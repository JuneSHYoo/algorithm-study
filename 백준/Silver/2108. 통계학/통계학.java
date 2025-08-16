
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int sum = 0 ;

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(br.readLine());
            sum += n;
            nums[i] = n;
        }
        Arrays.sort(nums);
        // 1. 산술평균
        int mean = ( (int) Math.round(((double) sum) / N)); // 소수점 버려지는거 방지
        bw.write(String.valueOf(mean)+"\n");
        // 2. 중앙값
        bw.write(String.valueOf(nums[(N-1)/2])+ "\n");

        // 3. 최빈값
        int count = 0;
        int max = -1; // 지금까지 본 값들 중 최빈값 횟수
        int mod = nums[0]; // 최빈값
        boolean chk = false;
        for(int i=0;i<N-1; i++){
            if(nums[i] == nums[i+1]){
                count++;
            }else{
                count=0;
            }

            if(max < count){
                max = count;
                mod = nums[i];
                chk = true;
            }else if(max == count & chk == true){
                mod = nums[i];
                chk = false;
            }
        }
        bw.write(String.valueOf(mod)+"\n");

        // 4. 범위
        int range = nums[N-1] - nums[0];
        bw.write(String.valueOf(range));
        
        bw.flush();
        bw.close();

    }
    
}
