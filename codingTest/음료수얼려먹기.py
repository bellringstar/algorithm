# N x M 크기의 얼음틀 영역의 개수
# 반복을 돌며 0인 지점에서 탐색 시작
# -> 1로 바꿔가며 처리 탐색 끝 => cnt ++
# 1초 2천만, 백만 4MB
from collections import deque

N, M = map(int, input().split())  # 1<=N,M<=1000

graph = [list(input()) for _ in range(N)]
cnt = 0


def bfs(r, c, graph):
    graph[r][c] = "1"
    q = deque()
    q.append((r, c))
    while q:
        now = q.popleft()
        for d in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            new_r, new_c = now[0] + d[0], now[1] + d[1]
            if new_r < 0 or new_r >= N or new_c < 0 or new_c >= M:
                continue
            if graph[new_r][new_c] == "0":
                graph[new_r][new_c] = "1"
                q.append((new_r, new_c))


for r in range(N):
    for c in range(M):
        if graph[r][c] == "0":
            # 시작점
            bfs(r, c, graph=graph)
            cnt += 1
print(cnt)
