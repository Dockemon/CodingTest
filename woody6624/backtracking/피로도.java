class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        // 던전을 갔는지 체크 여부 -> 백트래킹 + dfs
        int number = dungeons.length;
        // 던전의 각 단계를 거치는 dfs를 구성해야한다.
        for(int i = 0; i < number; i++){
            boolean [] dungeonCheck = new boolean[number];
            // 만약 던전의 피로도 요구치보다 현재 피로도가 높거나 같다면
            if(dungeons[i][0] <= k && !dungeonCheck[i]){
                int tired = k;
                System.out.println("던전 필요 필요도" + dungeons[i][0]+ "현재 피로도" + k);
                // 던전으로 진입하여 완전 탐색 진행
                // 피로도 깎고 방문표시하고 진행
                tired -= dungeons[i][1];
                dungeonCheck[i] = true;
                dfs(i, dungeonCheck, dungeons, 1, tired);
                
            }
        }
        return max;
    }
    // 백트래킹의 조건
    // 던전의 피로도 요구치보다 현재 피로도가 더 낮다 -> 종료
    private void dfs(int startDungeon, boolean[] dungeonCheck, int [][] dungeons, int depth, int k){
        int number = dungeons.length;
        max = Math.max(max, depth);
        if(depth == number) return;
        
        // 다음 던전으로 가는 갈림길에 섰다.
        for(int i = 0; i < number; i++){
            if(dungeons[i][0] <= k && !dungeonCheck[i]){
                dungeonCheck[i] = true;
                dfs(i, dungeonCheck, dungeons, depth + 1, k - dungeons[i][1]);
                dungeonCheck[i] = false;
            }
        }
    }
}