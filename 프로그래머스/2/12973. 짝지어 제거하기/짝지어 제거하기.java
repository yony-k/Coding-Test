import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        String[] arr = s.split("");
        Stack<String> st = new Stack<>();
        
        for(String tmp : arr) {
            if(!st.empty() && tmp.equals(st.peek())) {
                st.pop();
            } else {
                st.push(tmp);
            }
        }
        
        int answer = st.empty() ? 1 : 0;
        return answer;
    }
}