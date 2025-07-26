import java.util.*;
class Solution
{
    public int solution(String s)
    {   
        char [] charArr = s.toCharArray();
        Stack<Character> stacks = new Stack<>();
        // baabaa -> b aa baa -> bbaa -> 의 구조라면
        // 스택을 기준으로 생각했을떄 b를 먼저 넣고 그 후에 b랑 비교했을 떄 a가 들어오므로 a또한 넣어준다.
        // 이제 a가 들어오게 되는데 a는 스택의 최상단 값과 같기에 스택의 최상단을 pop해준다(a는 push X)
        // 이 시점에서 스택은 b
        // 다시 스택의 최상단인 b인 상황인데 그 다음에 오는 값은 b이다 -> 스택의 최상단을 pop해준다(b는 push X)
        // 이 시점에서 스택은 비어있기 떄문에 a를 넣어준다(for 문을 완전히 돌 때까지)
        for(int i = 0; i < s.length(); i++){
            // 만약 스택이 완전히 비어있다면 스택을 채워줍니다.
            if(stacks.isEmpty()) stacks.push(charArr[i]);
            // 만약 스택의 최상단 값과 charArr[i]의 값이 같다면 스택의 최상단 값을 제거합니다.
            else if(!stacks.isEmpty() && stacks.peek() == charArr[i]){
                stacks.pop();
            }
            // 그 이외의 경우는 스택을 채워줍니다.
            else{
                stacks.push(charArr[i]);
            }
        }
        if(stacks.isEmpty()){
            return 1;
        }

        return 0;
    }
}