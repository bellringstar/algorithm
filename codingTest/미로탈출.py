# 1초 2천만번 100만개 4MB
# N x M 직사각형미로 시작위치 (1,1) 출구 (N,M)
# 0은 벽 1은 통로 출구까지 최소칸 -> BFS
from collections import deque

N, M = map(int, input().split())

graph = [list(map(int, input())) for _ in range(N)]

# (0,0) -> (N-1, M-1) 즉 탐색을 하며 현재 좌표가 (N-1, M-1)일떄의 cnt


def bfs():
    q = deque()
    q.append((0, 0))
    while q:
        now = q.popleft()
        for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            new_r, new_c = now[0] + dr, now[1] + dc
            if new_r < 0 or new_r >= N or new_c < 0 or new_c >= M:
                continue
            if graph[new_r][new_c] == 1:
                q.append((new_r, new_c))
                graph[new_r][new_c] = graph[now[0]][now[1]] + 1
        for row in graph:
            print(*row)
        print()


bfs()


print(graph[N - 1][M - 1])
