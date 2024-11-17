class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=Math.sqrt(yellow); i++) {
            if(yellow % i == 0) {
                int width = yellow / i;
                int length = i;
                int calcul = (width*2) + (length*2) + 4;
                
                if(calcul == brown) {
                    answer[0] = width+2;
                    answer[1] = length+2;
                }
            }
        }
        
        return answer;
    }
}