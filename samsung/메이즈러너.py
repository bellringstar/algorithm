# 2023 상반기 오후 1번
# 거리 계산 = |x1-x2| + |y1-y2|
# 1초에 한칸씩 모든 참가자가 동시에 상하좌우
# 이동후 위치는 출구까지 거리가 가까워야한다. 2개 이상이라면 상하로 움직이는 것이 우선시된다.
# 움직일 수 없다면 움직이지 않아도된다/ 같은 칸에 두명 이상이 위치할 수 있다.
# 모든 참가자의 이동이 끝나면 미로는 회전한다 -> 벽의 내구도 1감소
# 한 명 이상의 참가자와 출구를 포함한 가장 작은 정사각형을 잡느다.
# 가장 작은 크기를 갖는 정사각형이 2개 이상이라면 좌상단 r좌표가 작은 것이 우선시되고, 그래도 같으면  c 좌표가 작은 것이 우선
# 정사각형은 시계방향으로 90도 회전하며 회전된 벽은 내구도가 1 깎인다.

N, M, K = map(int, input().split())
maze = [[-1] * (N+2) for _ in range(N+2)]
for i in range(1,N+1):
    row = list(map(int,input().split()))
    maze[i][1:N+1] = row


start = []
for _ in range(M):
    r,c = map(int,input().split())
    start.append((r,c))
    maze[r][c] = -100

for row in maze:
    print(*row)
print()

# 필요한 것들 1. 거리계산 -> 2. 상하좌우 중 이동 가능한곳 판별. 2-1 선택, 3. 이동(swap) 4.가능한 사각형 판별 4-1선택 5. 90도 회전

def calc_distance(r1, c1, r2, c2):
    return abs(r1-r2) + abs(c1-c2)

def next_position(r1, c1, r2, c2, dr, dc) -> bool:
    '''
    :param r1: 사람위치 r
    :param c1: 사람위치 c
    :param r2: 출구위치 r
    :param c2: 출구위치 c
    :param dr: 이동방향 dr
    :param dc: 이동방향 dc
    :return: 해당 방향으로 이동가능한가 -> boolean
    '''
    prev_dist = calc_distance(r1,c1,r2,c2)
    new_r, new_c = r1+dr, c1+dc
    dist = calc_distance(new_r, new_c, r2, c2)
    if dist < prev_dist:
        return True
    return False

def move(r1,c1,r2,c2):
    maze[r1][c1], maze[r2][c2] = maze[r2][c2], maze[r1][c1]

def find_rectangle(arr, r2, c2):
    '''
    :param arr: 참가자의 (r,c)가 들어있는 리스트
    :param r2: 출구 r2
    :param c2: 출구 c2
    :return: ((r1,c1),(r2,c2),(r3,c3),(r4,c4)) 사각형의 꼭지점을 우선순위 순으로 넣은 리스트
    '''
    for pos in arr:
        r1,c1 = pos[]


