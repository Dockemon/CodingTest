import java.util.*;
class Solution {
    int maxSheepCount = 0;
    public int solution(int[] info, int[][] edges) {
        // 결국 해당 문제는 모든 경우의 수를 체크해야 하므로 완전탐색(dfs) 문제로 볼 수 있다.
        // dfs를 구현하는 많은 방법이 있지만 노드의 수가 예측 가능한 범주 내에 존재하므로
        // 인접 리스트 방식을 통해 구현하고자 한다.
        int nodeAmount = info.length;
        List<Integer> [] graph = new ArrayList[nodeAmount];
        List<Integer> childNodes = new ArrayList<>();
        for(int i = 0; i < nodeAmount; i++){
            graph[i] = new ArrayList<>(); 
        }
        
        // 단방향 인접 리스트를 통해 이진 트리 구현
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        
        childNodes.addAll(graph[0]);
        
        dfs(1, 0,childNodes, graph, info);
        
        return maxSheepCount;
    }
    
    public void dfs(int sheepCount, int wolfCount, List<Integer> childNodes, List<Integer> [] graph, int [] info){
        // 만약 양이 늑대의 수보다 작거나 같은 경우라면 끝(집계를 할 필요가 X)
        if(sheepCount <= wolfCount) return;
        // 양의 최대 마리 수 업데이트
        maxSheepCount = Math.max(maxSheepCount, sheepCount);
        
        for(int i = 0; i < childNodes.size(); i++){
            
            int currentNodeIdx = childNodes.get(i);
            // 다음에 갈 후보군을 지정할 때는 우선 현재 위치한 depth의 노드들을 가져와야한다
            // 만약 가져오지 않는다면 좌측 뿌리와 우측 뿌리에서 내가 좌측 뿌리로 갔을때
            // 영원히 우측 뿌리를 탐색하지 않는다 -> 완전탐색이 아니게 된다.
            List<Integer> nextChildNodes = new ArrayList<>(childNodes);
            // 현재 도달한 노드만 정확하게 제거해준다.
            // 중복에 대한 문제는 생각하지 않아도 된다
            // 애당초 트리를 만들 때 단방향 이진트리로 구성했기 때문이다.
            nextChildNodes.remove(i);
            // 현재 도달한 노드를 제거한 후 해당 노드의 자식들을 더해주면 된다.
            nextChildNodes.addAll(graph[currentNodeIdx]);
            
            // 노드에 있는 친구가 양이라면
            if(info[currentNodeIdx] == 0){
                dfs(sheepCount+1, wolfCount, nextChildNodes, graph, info);
            }
            // 노드에 있는 친구가 늑대라면
            else if(info[currentNodeIdx] == 1){
                dfs(sheepCount, wolfCount+1, nextChildNodes, graph, info);
            }
        }
        
    }
}