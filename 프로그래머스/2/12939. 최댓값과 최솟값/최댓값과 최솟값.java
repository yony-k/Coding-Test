import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s, " ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            
            if(tmp > max) max = tmp;
            if(tmp < min) min = tmp;
        }
        
        return min + " " + max;
    }
}