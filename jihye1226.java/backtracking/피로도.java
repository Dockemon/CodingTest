class Solution {
    public int answer=0;
    public boolean [] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }
    public void dfs(int currentK, int count, int[][] dungeons){
        answer = Math.max(count,answer);
        for(int i=0;i<dungeons.length;i++){
            int requiredK = dungeons[i][0];
            int costK = dungeons[i][1];
            if(!visited[i]&&currentK>=requiredK){
                visited[i]=true;
                dfs(currentK-costK,count+1,dungeons);
                visited[i]=false;
            }
        }
    }
}