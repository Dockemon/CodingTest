import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.peek()] = n-stack.peek()-1;
            stack.pop();
        }
    
                  
        return answer;
    }
}