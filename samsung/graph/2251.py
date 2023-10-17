from collections import deque
import sys, copy
input = sys.stdin.readline

limit = list(map(int, input().split()))
C = set()
visited = [[[False] * 202 for _ in range(202)] for _ in range(202)]

def move(curr:list, f:int, t:int) -> list:
    # 현재 상태, f -> t로 이동
    rst = copy.deepcopy(curr)
    if curr[f] + curr[t] > limit[t]:
        # f -> t로 이동하는데 t의 용량보다 많다.
        rst[t] = limit[t]
        rst[f] -= limit[t] - curr[t]
    else:
        rst[t] = curr[t] + curr[f]
        rst[f] = 0
    return rst

def bfs():
    q = deque()
    q.append([0, 0, limit[2]])
    visited[0][0][limit[2]] = True
    while q:
        curr = q.popleft()
        if curr[0] == 0: C.add(curr[2])
        for f in range(3):
            for t in range(3):
                if f == t: continue
                rst = move(curr, f, t)
                if visited[rst[0]][rst[1]][rst[2]]: continue
                visited[rst[0]][rst[1]][rst[2]] = True
                q.append([rst[0], rst[1], rst[2]])

bfs()
C = sorted(C)
for num in C:
    print(num)
