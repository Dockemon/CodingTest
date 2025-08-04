import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> clothesMap=new HashMap<>();
        // 의상 종류별로 개수를 카운트합니다.
        for(String[] cloth : clothes) {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        // 조합 계산: 각 의상 종류마다 종류의 개수에 1을 더한 값을 곱하고 -1을 해줍니다.
        int answer = 1;
        for(int count : clothesMap.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}