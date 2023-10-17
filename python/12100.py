# 4 x 4 보드판, 상하좌우 이동. 같은 값을 갖는 두 블록이 충돌 -> 하나로 합쳐진다. 모든 블록은 함꼐 이동한다.
# 이미 합쳐진 블록은 다시 합칠 수 없다.
# N x N 보드판에서 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]

# 상황정리
# 1. 상하좌우로 이동한다. -> 언제까지? 경계부분까지.
# 1-1. 경계부분에 여러개가 겹치게 되는 경우 -> 재귀를 통해 합친다.
# 1-2. 이동 거리를 측정해 숫자가 같으면 합친다. 숫자가 다르다? 위치를 조절한다.(이동거리가 짧을수록 먼저 나오게)
# 1-3. 2244 같은 식으로 한 곳에 4개가 있다? -> 2와2가 같으므로 합친다 ->4
# 나머지는 위치를 하나 조정하고 다시 합칠수 있나 판단한다.

# 2. 이동하는 방식은 어떻게 처리하는가.
# 2-1. 어차피 모든 위치는 끝에 모이게 된다.
# 좌 -> c의 인덱스를 0으로 / 우 -> c의 인덱스를 N-1로
# 상 -> r의 인덱스를 0으로/ 하 r의 인덱스를 N-1로 // 거리는 현재 idx - 기준위치의 절대값

# 3. 5번의 이동을 어떻게 처리할 것인가.
# 3-1. 모든 위치를 리스트에 넣고 이동처리 후 합 계산
# 3-2. 새로운 위치들을 다시 리스트에 넣고 재귀처리 -> 완전탐색? bfs?

blocks = []
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            blocks.append((i,j,board[i][j]))

def move(r, c, value, direction):
    if direction == 'left':
        return c, r, 0, value #거리, r,c,값
    elif direction == 'right':
        return abs(N-1-c), r, N-1, value
    elif direction == 'up':
        return r, 0, c, value
    else:
        return abs(N-1-r), N-1, c, value

def sum_block(lst, direction): # lst : 이동 후 (거리, r, c, 값)리스트
    visited = [[0] * N for _ in range(N)]
    lst.sort()
    rst = []
    for block in lst:
        if visited[block[1]][block[2]] == 0:
            visited[block[1]][block[2]] = [0, block[3], False]
        else:
            #이미 해당 위치에 돌이 존재
            if visited[block[1]][block[2]][1] == block[3] and visited[block[1]][block[2]][2] == False:
                visited[block[1]][block[2]][1] = block[3]*2
                visited[block[1]][block[2]][2] = True
                # 위치 조정
                # 조정 할 때 기존에 있는 것의 +1을 하면 덮어씌워진다.
            else:
                visited[block[1]][block[2]][0] += 1
                cnt = visited[block[1]][block[2]][0]
                if direction == 'left':
                    visited[block[1]][block[2]+cnt] = [0, block[3], False]
                elif direction == 'right':
                    visited[block[1]][block[2]-cnt] = [0, block[3], False]
                elif direction == 'up':
                    visited[block[1]+cnt][block[2]] = [0, block[3], False]
                elif direction == 'down':
                    visited[block[1]-cnt][block[2]] = [0, block[3],False]

    for i in range(N):
        for j in range(N):
            if visited[i][j] != 0:
                rst.append((i,j,visited[i][j][1]))
    return rst

def find_max(lst):
    #sum_block의 리턴을 받는다.
    max_value = lst[0][2]
    for i in lst:
        if i[2] > max_value:
            max_value = i[2]
    return max_value

max_value = -int(1e9)

def dfs(k:int, arr:list):
    # graph = [[0] * N for _ in range(N)]
    # for cand in arr:
    #     graph[cand[0]][cand[1]] = cand[2]
    # for row in graph:
    #     print(*row)
    # print()
    global max_value
    if k >= 5:
        return
    for d in ('left', 'right', 'up', 'down'):
        # print(d)
        lst = []
        for block in arr:
            distance, new_r, new_c, value = move(block[0], block[1], block[2], d)
            lst.append((distance, new_r, new_c, value))
        new_blocks = sum_block(lst,d)
        max_value = max(find_max(new_blocks), max_value)
        dfs(k+1, new_blocks)

dfs(0, blocks)

print(max_value)