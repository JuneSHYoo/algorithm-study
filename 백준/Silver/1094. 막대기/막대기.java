import java.io.*;
import java.util.*;

public class Main {

    static int X;
    static int ans =0; 
    static int n = 64;
    static int sum =0;
    static Stack<Integer> nums = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer X = Integer.parseInt(br.readLine());
        nums.add(n);
        sum = getSum(nums);

        while(sum!=X){
            n = nums.pop();
            
            if((n/2 + (sum-n))>=X) {
                nums.add(n/2);
            }
            if((n/2 + (sum-n))<X) {
                nums.add(n/2);
                nums.add(n/2);
            }
            sum = getSum(nums);
        }
        
        ans = nums.size();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();


    }

    private static int getSum(Stack<Integer> s){
        int sum =0;
        for(int i=0; i<s.size();i++){
            sum += s.get(i);
        }
        return sum; 
    }
    
}
