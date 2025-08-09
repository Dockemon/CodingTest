class Solution {
    public int solution(int n, int[][] computers) {
        // 해당 문제는 결국 한 줄로 이어진 노드들에 대해서는 1개의 그룹 네트워크로 카운트
        // 풀이 방법을 생각해보면 각 노드마다 찍고 visited 체크하면 그만일 거 같다.
        int len = computers.length;
        
        boolean [] visited = new boolean[len];
        // 각 노드 번호에서 출발해보기
        int count = 0;
        for(int i =0; i < len; i++){
            if(visited[i] == false){
                dfs(i, computers, visited);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int currentNode, int [][] computers, boolean []visited){
        visited[currentNode] = true;

        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[currentNode][i] == 1){
                dfs(i, computers, visited);
            }
        }
    }
}