class Solution
{
    public int solution(int n, int a, int b)
    {
        // 3이 승리하고 다음 라운드에서 2번을 부여받는 것으로 보아 3/2 + 1 임을 알 수 있다.
        // 배열을 지속적으로 업데이트하고 만약 원하는 a와 b가 
        // 특정 배열에서 1,2 혹은 3,4와 같이 %2를 하였을때 값이 1과 0이며 두 수가 연속한 숫자라면
        // 문제가 주는 조건을 만족할 수 있다.
        int answer = 0;
        int tmp = 0; // swapValue
        // 풀이 과정의 통일성을 위해 항상 a가 b보다 작게 해준다 
        // a가 b보다 클 경우에 대하여 tmp를 활용해 변환
        if(a > b){
            tmp = a;
            a = b;
            b = tmp;
        }
        while(n >= 1){
            answer++;

            if (a + 1 == b && a % 2 == 1 && b % 2 == 0){
                break;
            }
            
            if(a % 2 == 1){
                a = a / 2 +1;
            }
            else{
                a = a / 2;
            }
            if(b % 2 == 1){
                b = b / 2 +1;
            }
            else{
                b = b / 2;
            }
            n = n/2;
        }
        return answer;
    }
}