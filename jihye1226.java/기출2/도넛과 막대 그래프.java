import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        //1단계 : 전체정점의 in-degree, out-degree 계산
        //HashMap 사용 <정점번호, in-degree, out
        Map<Integer, int[]> degrees = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];//나가는 정점
            int v = edge[1];//들어오는 정점
            
            //정점 u에 degree 정보가 없다면 하나 생성, 있다면 out-degree++
            degrees.computeIfAbsent(u, k -> new int[2])[1]++;
            //정점 v에 degree 정보가 없다면 하나 생성, 있다면 in-degree++
            degrees.computeIfAbsent(v, k -> new int[2])[0]++;
        }
        
        //2단계 생성 정점 찾기
        int generatedNode = -1;
        
        for(Map.Entry<Integer,int[]> entry : degrees.entrySet()){
            int node = entry.getKey();
            int[] info = entry.getValue();
            
            if(info[0]==0 && info[1]>=2){
                generatedNode = node;
                break;
            }
            
        }
        answer[0] = generatedNode;
        
        int totalGraphs = degrees.get(generatedNode)[1];
        int barCount = 0;
        int eightCount = 0;
        
        for(Map.Entry<Integer, int[]> entry : degrees.entrySet()){
            int node = entry.getKey();
            int[] info = entry.getValue();
            
            if(node == generatedNode) continue;
            else if(info[1]==0) barCount++;
            else if(info[1]==2 && info[0]>=2) eightCount++;
            
        }
        answer[1] = totalGraphs - barCount - eightCount;
        answer[2] = barCount;
        answer[3] = eightCount;

        return answer;
    }
} 