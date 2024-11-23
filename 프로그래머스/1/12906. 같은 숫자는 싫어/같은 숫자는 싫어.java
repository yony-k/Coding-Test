import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i : arr) {
            if(st.peek() != i) st.push(i);
        }
        
        return st.stream().mapToInt(Integer::intValue).toArray();
    }
}