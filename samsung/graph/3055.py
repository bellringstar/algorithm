# 비버의 굴로 가능한 빨리 도망
# 비버도 이동하고 물도 확장한다 물도 비버도 .에만 이동이 가능하다.
# S: 고슴도치, D: 비버굴, X:돌, *: 물, .: 빈 공간
from collections import deque
R, C = map(int, input().split())
graph = [list(input()) for _ in range(R)]

waters = []

for i in range(R):
    for j in range(C):
        if graph[i][j] == '*':
           waters.append(('w',i,j))
        elif graph[i][j] == 'S':
            start = ('s',i,j)
        elif graph[i][j] == 'D':
            goal = ('g', i,j)

distance = [[0] * C for _ in range(R)]

def bfs():
    q = deque()
    for w in waters:
        q.append(w)
    q.append(start)
    while q:
        now = q.popleft()
        for dr, dc in ((-1,0), (1,0), (0,-1), (0,1)):
            new_r, new_c = now[1] + dr, now[2] + dc
            if new_r <0 or new_r>=R or new_c <0 or new_c>=C:
                continue
            if now[0] == 'w':
                if graph[new_r][new_c] != '.': continue
                graph[new_r][new_c] = '*'

            elif now[0] == 's':
                if graph[new_r][new_c] == '.':
                    graph[new_r][new_c] = 'S'
                    distance[new_r][new_c] = distance[now[1]][now[2]] + 1
                elif graph[new_r][new_c] == 'D':
                    return distance[now[1]][now[2]] + 1
                else:
                    continue
            q.append((now[0], new_r, new_c))

    return -1

ans = bfs()

if ans == -1:
    print("KAKTUS")
else:
    print(ans)




