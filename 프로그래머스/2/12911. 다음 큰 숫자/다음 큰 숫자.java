class Solution {
    public int solution(int n) {
        int answer = 0;
        int nC = Integer.bitCount(n);
        n++;
        
        while(true) {
            int mC = Integer.bitCount(n);
            if(mC == nC) { 
                answer = n;
                break;
            } else {
                n++;
            }
        }
        
        return answer;
    }
}