class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int extent = brown + yellow;
        
        for(int i=1; i<=Math.sqrt(extent); i++) {
            
            if(extent % i == 0) {
                int width = extent / i;
                int length = i;
                int calcul = (width*2) + ((length-2)*2);

                if(calcul == brown) {
                    answer[0] = width;
                    answer[1] = length;
                    break;
                }
            }
        }
        
        return answer;
    }
}