# NxM 크기의 보드 기울여서 구슬을 이동
# 빨간구슬만 구멍에 빠져야 성공, 각 구슬은 동시에 같은 칸에 있을 수 없다.
# 기울이는 동작은 '#', 'O'에 만나는 순간 종료
# 최소 몇번만에 빨간 구슬을 구멍으로?
from collections import deque

N, M = map(int, input().split())
graph = [input() for _ in range(N)]  # '.', '#', 'O', 'R', 'B'
visited = set()
# 각각 이동시킨다. 걸린 시간을 파악한다
# 만약 같은 위치라면 걸린 시간이 적은 아이가 먼저 도착한 공
# 최소? 그래프? -> BFS
# 1. BFS를 통해 공이 '#' 혹은 'O'가 닿을 때 까지 이동한다.
# 2. 이동 후 파란공이 'O'가 아니면서 빨간 공이 'O'인지 파악
# 3. 만약 같은 위치이면 시간을 비교해 위치 조정

for i in range(N):
    for j in range(M):
        if graph[i][j] == "R":
            r_start = (i, j)
        elif graph[i][j] == "B":
            b_start = (i, j)


def move(x, y, dx, dy):
    cnt = 0
    # '#'이나 'O'가 아닐때까지 계속 이동
    while graph[x + dx][y + dy] != "#" and graph[x][y] != "O":
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt


def bfs():
    q = deque([(r_start, b_start, 0)])
    visited.add((r_start[0], r_start[1], b_start[0], b_start[1]))
    while q:
        red, blue, depth = q.popleft()

        if depth >= 10:
            break
        for dx, dy in ((0, -1), (0, 1), (1, 0), (-1, 0)):
            new_red_x, new_red_y, red_cnt = move(red[0], red[1], dx, dy)
            new_blue_x, new_blue_y, blue_cnt = move(blue[0], blue[1], dx, dy)
            if graph[new_blue_x][new_blue_y] != "O":
                if graph[new_red_x][new_red_y] == "O":
                    return depth + 1

                if new_red_x == new_blue_x and new_red_y == new_blue_y:
                    if red_cnt > blue_cnt:
                        # red 위치 조정
                        new_red_x -= dx
                        new_red_y -= dy
                    else:
                        # blue 위치 조정
                        new_blue_x -= dx
                        new_blue_y -= dy
                if (new_red_x, new_red_y, new_blue_x, new_blue_y) not in visited:
                    visited.add((new_red_x, new_red_y, new_blue_x, new_blue_y))
                    q.append(
                        ((new_red_x, new_red_y), (new_blue_x, new_blue_y), depth + 1)
                    )
    return -1


print(bfs())
