import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        
        int tmp = arr[arr.length-1];
        
        while(true) {
            boolean check = true;
            
            for(int i=0; i<arr.length; i++) {
                if(tmp % arr[i] != 0) check = false;
            }
            if(check) { 
                answer = tmp; 
                break;
            }
            tmp += arr[arr.length-1];
        }
    
        return answer;
    }
}