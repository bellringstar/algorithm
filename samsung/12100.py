# 상하좌우 이동.
# 같은 값이 충돌 -> 하나로 합쳐진다.
# 1회 이동에 한번 합처진 블록은 다시 합처질수 없다
# ex) 2 2 4 -> 4 4

# 1. 이동
# 2. 합치기
# 3. 5회까지 가능 dfs를 통해 모든 경우 확인

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

blocks = []
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            blocks.append((i, j, board[i][j]))


def move(r, c, value, dr, dc):
    """
    (r,c,value, dr,dc)를 받아 이동 후 (이동 거리, r, c, value)를 리턴한다.
    """
    if (dr, dc) == (0, -1):
        # left 이동 -> 모든 column index가 0으로
        return (c, r, 0, value)
    elif (dr, dc) == (0, 1):
        # right 이동 -> 모든 column index가 N-1으로
        return (N - 1 - c, r, N - 1, value)
    elif (dr, dc) == (-1, 0):
        # up 이동 -> 모든 row index가 0으로
        return (r, 0, c, value)
    elif (dr, dc) == (1, 0):
        # down 이동 -> 모든 row index가 N-1으로
        return (N - 1 - r, N - 1, c, value)



def sum_block(arr, dr, dc):
    """
    (이동거리, r, c, value)리스트와 (dr,dc)를 받아 합치고 위치 조정
    최종 조정된 데이터를 (r,c,value) 리스트로 리턴
    """
    visited = [[0] * N for _ in range(N)]
    is_sum = set()
    arr.sort()  # 이동거리 기준 오름차순 정렬
    rst = dict()
    blocks = []
    for block in arr:
        if visited[block[1]][block[2]] == 0:
            rst[(block[1], block[2])] = block[3]
            visited[block[1]][block[2]] = 1
        else:
            # 이미 먼저 도착한 블럭이 존재
            if rst[(block[1], block[2])] == block[3] and (block[1], block[2]) not in is_sum and visited[block[1]][block[2]] == 1:
                rst[(block[1], block[2])] = block[3] * 2
                is_sum.add((block[1], block[2]))
            else:
                # 존재하지만 값이 달라 합칠 수 없다면
                cnt = visited[block[1]][block[2]]
                if (dr, dc) == (0, -1):
                    # left => c를 증가시켜 저장한다.
                    rst[(block[1], block[2] + cnt)] = block[3]
                elif (dr, dc) == (0, 1):
                    # right = > c를 감소시켜 저장한다.
                    rst[(block[1], block[2] - cnt)] = block[3]
                elif (dr, dc) == (1, 0):
                    # down => r을 감소시켜 저장한다.
                    rst[(block[1] - cnt, block[2])] = block[3]
                elif (dr, dc) == (-1, 0):
                    rst[(block[1] + cnt, block[2])] = block[3]
                visited[block[1]][block[2]] += 1
    for key in rst.keys():
        blocks.append((key[0], key[1], rst.get(key)))
    return blocks


max_value = -int(1e9)


def dfs(k, blocks):
    print(f'blocks: {blocks}')
    graph = [[0] * N for _ in range(N)]
    for i in blocks:
        graph[i[0]][i[1]] = i[2]
    for row in graph:
        print(*row)
    print()
    global max_value
    if k >= 4:
        return
    for dr, dc in ((0, -1), (0, 1), (-1, 0), (1, 0)):
        print(f'이동 방향 : {(dr, dc)}')
        new_blocks = []
        for block in blocks:
            new_blocks.append(move(block[0], block[1], block[2], dr, dc))
        print(f'이동후 블록들: {new_blocks}')
        sum_blocks = sum_block(new_blocks, dr, dc)
        print(f'합친 후 블록들 : {sum_blocks}')
        for i in sum_blocks:
            max_value = max(max_value, i[2])
        dfs(k + 1, sum_blocks)


dfs(0, blocks=blocks)
print(max_value)