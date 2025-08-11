class Solution {
    int[] best = {-1};
    // 점수차이에 쓰일 값 resultValue
    int resultValue = -1;

    public int[] solution(int n, int[] info) {
        // 문제를 분석해보면 악랄한 라이언을 이기기 위해 꼼수를 부리는 문제이다.
        // 어피치와 라이언의 화살이 동일한 과녁판에 N발이 있을 경우 -> 어피치가 1 * 과녁판의 점수
        // 만큼의 점수를 획득한다.
        // 단 초기에 주어지는 값은 어피치가 맞춘 화살 정보가 담긴 과녁판
        // 이를 라이언이 이기기 위해 최적의 방법을 찾는 것이 포인트
        // 화살은 n개
        // 0점 과녁부터 depth를 1 증가시켜주면서 체크하면 되긴 하겠다
        // 완전탐색의 분기점 : 점수를 가져갈까 or 말까
        // 각 과녁점 마다 depth1 증가 ex) 10점 -> depth 1
        // 솔루션에서 dfs는 단 한번만 호출한다 (가지를 타고 가며 모든 경우의 수를 탐색하기 때문)
        int[] ryan = new int[11]; 
        dfs(0, n, info, ryan);
        return best;
    }

    public void dfs(int depth, int arrows, int[] apeach, int[] ryan) {
        if (depth == 11) {
            // 모든 과녁에 대한 결정이 마무리...
            // 주어진 조건에 따르면 
            // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지일 경우,
            // 가장 낮은 점수를 더 많이 맞힌 경우를 return
            // 남은 모든 화살은 가장 작은 값인 0에 전부 넣기
            ryan[10] += arrows;
            calcurate(apeach, ryan);
            // 0번 맞춘 개수 백트래킹
            ryan[10] = 0;
            return;
        }

        // dfs에서의 분기점
        // 해당 점수의 과녁을 가져갈 것인가?

        // 1. 해당 과녁을 포기하는 경우
        // 바로 다음번 점수 ex) 10 -> 9 로 넘어간다
        // 화살 개수의 변동 x
        dfs(depth + 1, arrows, apeach, ryan);

        // 2. 해당 과녁을 가져가는 경우
        // 어피치가 해당 과녁에 쏟은 화살 + 1 개를 소모해야한다.
        int acquireArrow = apeach[depth] + 1;

        // 단 이때 반드시 보유 화살이 소모할 화살보다 같거나 많아야한다.
        if (arrows >= acquireArrow) {
            // 라이언의 배열에 해당 값 부여
            ryan[depth] = acquireArrow;
            dfs(depth + 1, arrows - acquireArrow, apeach, ryan);
            // 백트래킹(dfs를 함에 있어서 문제가 발생하면 그 가지의 핵심은 버려야하기 때문)
            ryan[depth] = 0;
        }
    }

    // 점수차이 계산
    private void calcurate(int[] apeach, int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryan[i] > apeach[i]) {
                ryanScore += (10 - i);
            } else if (apeach[i] > 0) {
                apeachScore += (10 - i);
            }
        }

        // 라이언과 어피치의 점수 차이를 업데이트
        // 단 여기서 생각해야되는점 -> 만약 점수차이가 동일하다면?
        // 이때는 가장 낮은 점수를 더 많이 맞힌 경우를 return해야한다.
        int diff = ryanScore - apeachScore;

        // 이 경우에 낮은 점수를 더 많이 맞힌 경우를 return해야한다.
        if (diff > 0) {
            if (diff > resultValue) {
                best = ryan.clone();
                resultValue = diff;
            }
            
            else if(resultValue == diff){
                // 기존에 있던 best 배열에서 10번 인덱스 값부터 체크하며 
                // 10 -> 9 -> 8 순으로 내려가며 개수가 가장 많은 친구로 갈아끼우자
                for (int i = 10; i >= 0; i--) {
                    // 새로운 도전자 ryan과 기존 best와 대결에서 라이언이 더 적합한 애라면
                    if (ryan[i] > best[i]) {
                        best = ryan.clone();
                        break;
                    }
                    else if(best[i] > ryan[i]){
                        break;
                    }
                }
            }
            
        }
    }
}
