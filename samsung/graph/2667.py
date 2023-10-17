from collections import deque
N = int(input())

graph = [list(input()) for _ in range(N)]

home_cnt = 0

def bfs(r, c):
    cnt = 1
    q = deque()
    q.append((r, c))
    graph[r][c] = 0
    while q:
        now = q.popleft()
        for dr, dc in ((-1,0), (1,0), (0,-1), (0,1)):
            new_r, new_c =now[0]+dr, now[1]+dc
            if new_r < 0 or new_r >=N or new_c <0 or new_c >= N:
                continue
            if graph[new_r][new_c] == "1":
                graph[new_r][new_c] = 0
                cnt += 1
                q.append((new_r, new_c))
    return cnt
rst = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == "1":
            home_cnt += 1
            cnt = bfs(i,j)
            rst.append(cnt)
rst.sort()
print(home_cnt)
for i in rst:
    print(i)
