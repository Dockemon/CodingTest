import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] present = new int[friends.length];
        
        Map <String, Integer> friendsIndex = new HashMap<>();
            
        for(int i=0;i<friends.length;i++){
            friendsIndex.put(friends[i],i);
        }
        
        int[][] gift_table = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        
        for(String gift : gifts){
            String[] names = gift.split(" ");
            String giver = names[0];
            String receiver = names[1];
            
            int giverIndex = friendsIndex.get(giver);
            int receiverIndex = friendsIndex.get(receiver);
            
            gift_table[giverIndex][receiverIndex]++;
            
            giftIndex[giverIndex]++;
            giftIndex[receiverIndex]--;
            
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=i+1;j<friends.length;j++){
                if(gift_table[i][j]>gift_table[j][i]){
                    present[i]++;
                    if(answer<present[i]) answer = present[i];
                }
                else if(gift_table[j][i]>gift_table[i][j]){
                    present[j]++;
                    if(answer<present[j]) answer = present[j];
                }
                else if(gift_table[j][i]==gift_table[i][j]){
                    if(giftIndex[i]>giftIndex[j]) present[i]++;
                    else if(giftIndex[j]>giftIndex[i]) present[j]++;
                    
                    if(answer<present[i]) answer = present[i];
                    if(answer<present[j]) answer = present[j];
                }
            }
        }
        
        
        
        return answer;
    }
}