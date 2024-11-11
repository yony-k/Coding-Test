import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        int answer = 0;
        
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                answer = -1;
                break;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + (b*2));
            answer++;
        }
        
        return answer;
    }
}