# 이동한 칸의 수 0 -> 주사위에서 복사 / 0이 아니면 칸의 수가 주사위로 복사되고 0으로 바뀐다
# 주사위의 상단에 쓰여있는 수

# 결국 지도에서 주사위를 이동시키는 동작을 시행한다.

N, M, x, y, k = map(int, input().split())
graph = []
for _ in range(N):
    row = list(map(int, input().split()))
    graph.append(row)

directions = list(map(int, input().split())) # 1 동 2 서 3 북 4 남

dice = [[0] * 3 for _ in range(4)]

def move_dice(direction):
    tmp1 = dice[1][1]
    tmp2 = dice[1][2]
    tmp3 = dice[3][1]
    tmp4 = dice[1][0]
    if direction == 1: # 동
        dice[1][1] = tmp2
        dice[1][2] = tmp3
        dice[3][1] = tmp4
        dice[1][0] = tmp1
    elif direction == 2: #서
        dice[1][0] = tmp3
        dice[3][1] = tmp2
        dice[1][2] = tmp1
        dice[1][1] = tmp4
    elif direction == 3: #남 -> dice의 1열을 위쪽으로 1회 회전
        tmp = dice[0][1]
        for i in range(3):
            dice[i][1] = dice[i+1][1]
        dice[3][1] = tmp
    else: #북 - > dice의 1열을 아래쪽으로 1회 회전
        tmp = dice[3][1]
        for i in range(2, -1, -1):
            dice[i+1][1] = dice[i][1]
        dice[0][1] = tmp
# 이제 아래 부분은 항상 dice[1][1] 윗면은 dice[3][1]

for d in directions:
    if d == 1:
        dr, dc = (0, 1)
    elif d == 2:
        dr, dc = (0, -1)
    elif d == 3:
        dr, dc = (-1, 0)
    else:
        dr, dc = (1, 0)

    new_r, new_c = x + dr, y + dc
    if new_r < 0 or new_r >= N or new_c<0 or new_c >= M :
        continue
    x,y = new_r, new_c
    move_dice(d)
    if graph[x][y] == 0:
        graph[x][y] = dice[1][1]
    else:
        dice[1][1] = graph[x][y]
        graph[x][y] = 0
    print(dice[3][1])
