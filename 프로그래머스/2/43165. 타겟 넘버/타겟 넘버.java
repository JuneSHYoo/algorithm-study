import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, target, 0,0);
        return answer;
    }
    
    private static int dfs(int[] numbers, int target, int curSum , int index){
        if(index == numbers.length){
            if(curSum == target){
                return 1;
            }
            return 0;
        }
        
        int cnt = 0;
        cnt += dfs(numbers, target, curSum + numbers[index] , index+1);
        cnt += dfs(numbers, target, curSum - numbers[index] , index+1);
        
        return cnt;
        
    }
}

/**
    0
     +num[0]         -nums[0]
+nums[1] -nums[1]  +nums[1]  -nums[1]
*/