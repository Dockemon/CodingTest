import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 결국 해당 문제는 want와 number의 조합을 계산했을때 모두 만족하는 
        // 즉, 10일 동안 원하는 제품과 개수가 모두 들어있는 날(회원가입으로부터 10일 연속으로 일치)
        Map<String, Integer> discountPot = new HashMap<>();

        int answer = 0;

        int finalDay = 10;
        
        // 해시맵에 want를 키로 number를 값으로 저장
        for(int i = 0; i < want.length; i++){
            discountPot.put(want[i], number[i]);
        }
        
        // 매 루프마다 testPot은 저장해둔 discountPot를 복제하여 수행
        for(int i = 0; i < discount.length - finalDay+1; i++){
            Map<String, Integer> testPot = new HashMap<>(discountPot);
            boolean checkPass = false;
            for(int j = i; j < i + finalDay; j++){

                if(testPot.containsKey(discount[j])){
                     int fixInt = testPot.get(discount[j]) -1;
                     testPot.put(discount[j], fixInt);
                }
               
            }
            
            // 만약 모든 키(want)의 값(number)이 0이라면 만족하는 경우이기에 
            // answer의 값을 1 증가
            for(String wantKey : testPot.keySet()){
                if(testPot.get(wantKey) == 0){
                    checkPass = true;
                }
                else{
                    checkPass = false;
                    break;
                }
            }
            
            if(checkPass == true){
                answer++;
            }
        }
        
        return answer;
    }
}