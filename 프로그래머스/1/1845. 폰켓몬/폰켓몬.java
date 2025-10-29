import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> s = new HashSet<Integer>();
        for(int n : nums){
            s.add(n);
        }
        
        int cnts = s.size();
        int len = nums.length;
        
        if(cnts < len/2){ 
            return cnts;
        }else{
            return len/2;
        }
        
    }
}