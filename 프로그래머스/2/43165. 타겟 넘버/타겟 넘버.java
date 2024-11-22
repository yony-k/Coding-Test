class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        
        dfs(numbers, target, 0, 0);
        
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int dept, int sum) {
        if(dept == numbers.length) {
            if(target == sum) answer++;
            return;
        }
        
        dfs(numbers, target, dept+1, sum + numbers[dept]);
        dfs(numbers, target, dept+1, sum - numbers[dept]);        
    }
}