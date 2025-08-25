class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int maxX = board[0] / 2;
        int minX = -maxX;
        int maxY = board[1] / 2;
        int minY = -maxY;
        
        
        for(int i=0;i<keyinput.length;i++){
            if("left".equals(keyinput[i])) answer[0]--;
            else if("right".equals(keyinput[i])) answer[0]++;
            else if("up".equals(keyinput[i])) answer[1]++;
            else if("down".equals(keyinput[i])) answer[1]--;
            
            if(answer[0]>maxX) {
                answer[0] = maxX;
            }
                
            else if (answer[0] < minX) {
                answer[0] = minX;
            }
                
            if(answer[1] > maxY) {
                answer[1] = maxY;
            }
            
            else if(answer[1] < minY){
                answer[1] = minY;
            }
            
        }
        return answer;
    }
}