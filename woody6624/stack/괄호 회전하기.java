import java.util.Stack;

class Solution {
    int answer = 0;

    public int solution(String s) {
        // s를 왼쪽으로 x칸만큼 회전
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) answer++;
        }
        return answer;
    }

    public boolean isValid(String s) {
        Stack<Character> stacks = new Stack<>();
        for (char c : s.toCharArray()) {
            // 만약 스택에 아무거도 없다면
            if (c == '(' || c == '{' || c == '[') {
                stacks.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // 만약 윗 단계를 안거치고 아무것도 푸쉬가 돼지않앗다면 끝 오른쪽 괄호일 경우이기 떄문이다.
                if (stacks.isEmpty()) return false;
                else {
                    // 만약 괄호가 완성이 되는 조건이라면 오른쪽 괄호를 추가해주는 것이 아니라
                    // 기존에 추가해놨던 왼쪽 괄호를 없애준다.
                    if (c == ')' && stacks.peek() == '(') stacks.pop();
                    else if (c == ']' && stacks.peek() == '[') stacks.pop();
                    else if (c == '}' && stacks.peek() == '{') stacks.pop();
                    else {
                        stacks.push(c);
                    }
                }
            }
        }
        // 모든 문자를 순회했을 때 stack이 비어있다면 true 그렇지않다면 false    
        // stack이 비어있다는 것은 맞아 떨어지는 괄호들로 구성되어있다는 것을 증명해주기 떄문이다.
        if (stacks.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
