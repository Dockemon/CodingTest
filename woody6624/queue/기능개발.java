import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서대로 꺼내서 처리하면 생각보다 간단하게 풀릴 것 같다
        // 우선 완료가 되는 시점을 저장하는 배열이나 자료구조가 필요할 것 같다(ex. 해시맵이나 리스트 or 큐,덱)
        // 하지만 해시맵이나 리스트의 경우 모든 자료구조를 순환하며 체크하므로 부적합하다.

        Queue<Integer> finishSchedule = new LinkedList<>();
        List<Integer> returnValue = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            // 소요 시간을 finishSchedule에 저장
            // 다만 이때 딱 떨어지는 수라면 상관이 없지만 만약 2.4 이런 식으로 소수점으로 나눠 떨어진다면
            // 올림 처리를 해서 3일이 걸리는 작업이라 해야하기 때문에
            // Math.ceil을 통하여 올림 처리를 수행(만약 내림을 했었어야하는 문제라면 Math.floor)
            finishSchedule.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        // Queue 자료구조를 사용했다면 문제를 단번에 해결할 수 있다.
        // Queue에서 지속적으로 peek()하고 remove()하는 형식을 통해
        // peek()한 값이 기준 값보다 같거나 작다면 해당 값을 remove()
        // remove()를 하였으므로 count를 1씩 증가시켜주면 해결할 수 있다.
        while(!finishSchedule.isEmpty()){
            int count = 0;
            // 기준 값을 먼저 체크
            int standardValue = finishSchedule.peek();
            finishSchedule.remove();
            count++;
            while(!finishSchedule.isEmpty() && standardValue >= finishSchedule.peek()){
                finishSchedule.remove();
                count++;
            }
            returnValue.add(count);
        }
        int [] returnArr = returnValue.stream().mapToInt(Integer::intValue).toArray();
        return returnArr;  
    }
}