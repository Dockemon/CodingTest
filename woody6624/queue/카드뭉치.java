import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 첫 번째 카드뭉치와 두 번째 카드 뭉치를 각각 큐로 뺀다면
        // 골이 원하는 카드 조합에 맞추어 for문을 통해 골 배열을 순회하며
        // 카드 뭉치에 존재한다면 제거를 해주며 넘어가고 만약 존재하지 않는(순번상) 문자라면
        // 바로 No를 리턴해주면 해결할 수 있다.
        Queue<String>  cards1Queue = new LinkedList<>();
        Queue<String>  cards2Queue = new LinkedList<>();
        for(int i = 0; i < cards1.length; i++){
            cards1Queue.add(cards1[i]);
        }
        
        for(int i = 0; i < cards2.length; i++){
            cards2Queue.add(cards2[i]);
        }        
        
        for(int i = 0; i < goal.length; i++){
            if(!cards1Queue.isEmpty() && cards1Queue.peek().equals(goal[i])){
                cards1Queue.poll();
            }
            else if(!cards2Queue.isEmpty() && cards2Queue.peek().equals(goal[i])){
                cards2Queue.poll();
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}