class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i=0;i<n;i++){
            if(!chk[i]){
                answer++;
                dfs(i, n, computers, chk);
            }
        }
        return answer;
    }
    
    public void dfs(int current_computer, int n, int[][] computers, boolean[] chk ){
        chk[current_computer] = true;
        
        for(int next_computer=0;next_computer<n;next_computer++){
            if(computers[current_computer][next_computer]==1 && !chk[next_computer]){
             dfs(next_computer, n, computers, chk);
            }
        }
    }
}