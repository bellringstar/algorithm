# 1. 몸의 길이를 늘려 머리를 다음칸으로 이동
# 2. 머리가 벽이나 자기 자신의 몸과 부딛히면 게임 끝
# 3. 머리가 사과를 만나면 사과가 사라지고 꼬리가 그대로 -> 즉 길이가 1 증가
# 4. 머리의 위치에 아무것도 없다 -> 꼬리의 자리를 비워주고 이동 -> 즉 길이 유지
# 시작 좌표 1,1
from collections import deque
N = int(input())
K = int(input())
graph = [[-1] * (N+2) for _ in range(N+2)] #시작좌표 1,1을 위해 더미를 넣는다.

for i in range(1, N+1):
    for j in range(1, N+1):
        graph[i][j] = 0
graph[1][1] = 1 #뱀의 초기 위치

for _ in range(K):
    i,j = map(int, input().split())
    graph[i][j] = 2


L = int(input())
changes = deque([list(input().split()) for _ in range(L)])
# X, C = X초가 끝난 뒤 왼쪽(L), 오른쪽(D)로 회전

cnt = 0
snakes = deque()
snakes.append((1,1))
def move(r,c,dr,dc):
    '''
    :param r: 현재 r
    :param c: 현재 c
    :param dr: 이동 방향 dr
    :param dc: 이동 방향 dr
    :return:
    '''
    global cnt
    new_r, new_c = r + dr, c + dc
    if graph[new_r][new_c] == -1 or graph[new_r][new_c] == 1:
        #벽에 박은 상황
        return False
    elif graph[new_r][new_c] == 2: #사과를 먹은 순간
        snakes.append((new_r, new_c))
        graph[new_r][new_c] = 1
        cnt += 1
        return True
    else: # graph[new_r][new_c] == 0 : 빈 공간
        prev_r, prev_c = snakes.popleft()
        graph[prev_r][prev_c] = 0
        graph[new_r][new_c] = 1
        snakes.append((new_r, new_c))
        cnt += 1
        return True

def change_d(r,c,direction:str):
    if direction == 'D':
        if (r,c) == (0,1):
            return (1,0)
        elif (r,c) == (0,-1):
            return (-1,0)
        elif (r,c) == (1,0):
            return (0,-1)
        elif (r,c) == (-1,0):
            return (0,1)
    else:
        if (r, c) == (0, 1):
            return (-1, 0)
        elif (r, c) == (0, -1):
            return (1, 0)
        elif (r, c) == (1, 0):
            return (0, 1)
        elif (r, c) == (-1, 0):
            return (0, -1)


def game():
    current_pos = (1,1)
    current_direction = (0, 1)
    change = changes.popleft()
    change_time = int(change[0])
    change_direction = change[1]
    while True:
        ans = move(current_pos[0], current_pos[1], current_direction[0], current_direction[1])
        # for row in graph:
        #     print(*row)
        if ans == False:
            return cnt + 1
        current_pos = snakes[-1]
        if cnt == int(change_time): # 방향 전환 로직
            current_direction = change_d(current_direction[0], current_direction[1], change_direction)
            if changes:
                next_time = changes.popleft()
                change_time, change_direction = int(next_time[0]), next_time[1]



rst = game()

print(rst)


