import java.io.*;

// 백준 소수&팰린드롬 실버1
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        while(true){
            if(isPrime(N)&& isPalindrom(N)){
                bw.write(String.valueOf(N));
                break;
            }
            N++;
        }
        bw.flush();
        bw.close();
        
    }

    private static boolean isPrime(int n){
        if(n<2) return false;

        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    private static boolean isPalindrom(int n){
        int newn = 0;
        int orgn = n;

        while(n>0){
            int remain = n % 10; 
            n = (n - remain)/10; 
            if(remain == 0){
                newn *= 10;
            }else{
                newn = newn*10+remain;  
            }
        }

        if(orgn == newn){
            return true;
        }

        return false;
    }


    
}
