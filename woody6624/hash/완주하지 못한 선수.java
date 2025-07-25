import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
       // 이름-명 수  이 key-value 구조로 만든 후 completion에서 존재하는 이름의 명 수를 
        // 체크해가며 뺀다면 해결할 수 있을 것 같다
        Map<String, Integer> participantGroup = new HashMap<>();
        for(int i = 0; i< participant.length; i++){
            if(!participantGroup.containsKey(participant[i])){
                participantGroup.put(participant[i], 1);
            }
            else{
                int upCount = participantGroup.get(participant[i]);
                upCount++;
                participantGroup.put(participant[i], upCount);
            }
        }
        
         for(int i = 0; i< completion.length; i++){
            if(participantGroup.containsKey(completion[i])){
                int t = participantGroup.get(completion[i]);
                t--;
                participantGroup.put(completion[i], t);
            }
        }
        for(String l : participantGroup.keySet()){
            if(participantGroup.get(l) > 0){
                return l;
            }
        }
        return null;
    }
}