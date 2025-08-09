class Solution {
    int answer = 0;
    public int solution(int n) {
        // 모든 퀸의 배치 경우의 수를 생각해야한다. -> 모든 경우의 DFS 혹은 BFS
        // 첫번째 열에 퀸 하나를 둔 후 나머지 3개를 depth를 늘려가며 진행한다.
        for (int i = 0; i < n; i++) {
                boolean [][] chessMap = new boolean [n][n];
                chessMap[0][i] = true;
                dfs(chessMap, 1);
            } 
        
        return answer;
    }
    // 다만 모든 경우의 수를 체크할 때 해당 지점의 퀸이 다른 퀸에게 공격당하는 위치라면?
    // 이후의 경우의 수 가지는 모두 소멸시킬 수 잇다.(백트래킹)
    private void dfs(boolean [][]chessMap, int depth){
        // dfs에서는 해당 지점에서 다른 퀸이랑 충돌 여부를 체크해야한다.
        // 만약 충돌한다면 해당 지점에서 dfs는 종료되며 방법의 수가 1 증가한다.
        // 체스의 충돌 경우를 생각해보자 단 하나라도 대각선 방향 혹은 좌 우 같은 열에
        // 다른 체스 말이 있을 경우 더 이상의 탐색은 종료하고 return해준다(해당 가지는 방법이 아니므로)
        int n = chessMap.length;
        if(depth == chessMap.length){
            answer++;   
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!chessMap[depth][i] && checkValid(depth, i, chessMap)){
                chessMap[depth][i] = true;
                dfs(chessMap, depth + 1);
                chessMap[depth][i] = false;    
            }
        } 
    }
    private boolean checkValid(int x, int y, boolean [][] chessMap){
        int n = chessMap.length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                if (chessMap[i][j]) {
                    // 같은 열
                    if (j == y) return false;
                    // 대각선 
                    if (Math.abs(x - i) == Math.abs(y - j)) return false;
                }
            }
        }

        return true;
    }
     
}