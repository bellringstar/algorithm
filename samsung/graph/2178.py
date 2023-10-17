from collections import deque

N, M = map(int, input().split())

graph = [list(map(int,input())) for _ in range(N)]


def bfs(i,j):
    q = deque()
    q.append((i, j))
    while q:
        now = q.popleft()
        for di, dj in ((-1,0), (1,0), (0,-1), (0,1)):
            new_i, new_j = now[0] + di, now[1] + dj
            if new_i<0 or new_i >= N or new_j <0 or new_j >= M:
                continue
            if graph[new_i][new_j] != 1:
                continue
            graph[new_i][new_j] = graph[now[0]][now[1]] + 1
            q.append((new_i, new_j))


bfs(0,0)

print(graph[N-1][M-1])