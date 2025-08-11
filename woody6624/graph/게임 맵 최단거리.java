import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        // 상하좌우로 이동
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        // 최단거리를 찾는다 -> BFS
        Queue<int []> queue = new LinkedList<>();
        // 결국 maps에서 모든 방향(동서남북)
        // 으로 가는 경우의 수에서 dfs의 for문 안에 동,서,남,북으로 가야하는 문제이다.
        // 캐릭터는 1,1에서 출발한다.
        // 단 1,1에서 출발하는 것은 0,0에서 출발하는 것으로 간주한다.
        // 밑으로 1칸 가면  x값이 +1
        // 오른쪽으로 1칸 가면 y의 값이 +1
        // 자바에서 이렇게 boolean을 명시적으로 초기화하지 않으면 전체 false
        boolean [][] checkVisited = new boolean[maps.length][maps[0].length];
        
        // 시작 지점에 대한 처리
        queue.offer(new int[]{0,0,1});
        checkVisited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int [] data = queue.poll();
            int getX = data[0];
            int getY = data[1];
            int getTry = data[2];
            // 만약 최종 목적지에 도달을 하였다면
            if (getX == maps.length - 1 && getY == maps[0].length - 1) {
               return getTry; 
            }
                        
            // 동, 서, 남, 북 4방향으로 이동하는 for문
            for (int i = 0; i < 4; i++) {
                int xDi = getX + dx[i];
                int yDi = getY + dy[i];
                if (xDi >= 0 && yDi >= 0 && xDi < maps.length && yDi < maps[0].length && checkVisited[xDi][yDi] == false
                   && maps[xDi][yDi] == 1) {
                    // 큐에 저장
                    queue.offer(new int[]{xDi, yDi, getTry + 1}); 
                    // 방문 체크
                    checkVisited[xDi][yDi] = true;
                }
                
            }   
        }
        
        int answer = -1;
        return answer;
    }
    
}