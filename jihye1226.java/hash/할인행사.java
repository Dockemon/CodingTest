import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantmap = new HashMap<>();
        for(int i=0;i<want.length;i++){
            wantmap.put(want[i],number[i]);
        }
        
        for(int i=0;i<=discount.length-10;i++){
            Map <String, Integer> discountmap = new HashMap<>();
            for(int j=i;j<i+10;j++){
                discountmap.put(discount[j],discountmap.getOrDefault(discount[j],0)+1);
            }
            if(isSame(wantmap,discountmap)) answer++;
        }
        return answer;
    }
    
    private boolean isSame(Map<String, Integer> a, Map<String, Integer> b){
        for(String key : a.keySet()){
            if(b.getOrDefault(key,0)!=a.get(key)) return false;
        }
        return true;
    }
    
}