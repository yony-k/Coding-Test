import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        
        PriorityQueue<Integer> qA = new PriorityQueue<>();
        PriorityQueue<Integer> qB = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++) {
            qA.add(A[i]);
            qB.add(B[i]);
        }
        
        int answer = 0;
        
        for(int i=0; i<A.length; i++) {
            answer += qA.poll() * qB.poll();
        }
        
        return answer;
    }

}