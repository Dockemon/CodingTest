# BFS 이용(deque 라이브러리)
# 지도 좌표 저장 -> 차례대로 꺼내서 퍼트려나가기 
# 갈 수 있는 방향 탐색하면서, (이전 위치의 값 + 1) 누적하여 거리 기록
from collections import deque

def solution(maps):
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    n = len(maps)
    m = len(maps[0])
    
    queue = deque()
    queue.append((0, 0))
    
    while queue: 
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 지도 범위 벗어나면 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            
            # 벽이거나 이미 방문한 노드면 무시
            if maps[nx][ny] > 1 or maps[nx][ny] == 0:
                continue
            
            # 다시 시작점으로 되돌아가는 경우 방지
            if nx == 0 and ny == 0:
                continue
            
            # 이동가능한 칸이라면 -> 현재 위치까지의 거리에 1 더해 저장
            maps[nx][ny] += maps[x][y]
            # 다음 위치를 큐에 삽입하여 계속 탐색
            queue.append((nx, ny))
    
    # 도착지점까지 누적된 값이 1 초과면 -> 최단거리 반환
    # 도작하지 못했다면 -> -1 반환
    return maps[n-1][m-1] if maps[n-1][m-1] > 1 else -1