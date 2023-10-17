# 연구소 NXM 바이러스가 상하좌우로 퍼진다. 새로 새울 수 있는 벽은 3개
# 0은 빈칸, 1은 벽, 2는 바이러스
# 벽을 잘 세워 안전영역의 크기를 최대로 만들자.(안전영역 = 0의 개수)

# 1. 벽을 세울 곳 3개를 고른다.
# 2. 바이러스를 퍼트린다. bfs
# 3. 안전영역의 크기의 최대를 갱신한다. -> 1번으로 돌아간다.

from collections import deque
import copy,sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
max_cnt = -int(1e9)
def bfs(r,c,graph):
    # 바이러스의 초기 위치로부터 퍼저나가는 형태
    q = deque()
    q.append((r,c))
    while q:
        now_r,now_c = q.popleft()
        for dr, dc in ((-1,0), (1,0), (0,1), (0,-1)):
            new_r,new_c = now_r+dr, now_c+dc
            if new_r<0 or new_r >=N or new_c < 0 or new_c >=M:continue
            if graph[new_r][new_c] != 0: continue
            graph[new_r][new_c] = 2
            q.append((new_r, new_c))

def count_safety(graph):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                cnt += 1
    return cnt

virus = []
cand = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            cand.append((i,j))
        elif graph[i][j] == 2:
            virus.append((i,j))

# 0의 좌표가 모인 리스트 cand 에서 3개의 순열을 뽑느다.
visited = [[False] * M for _ in range(N)]
select = [0] * 3
def rec_func(k):
    global max_cnt
    if k == 3:
        arr = copy.deepcopy(graph)
        # 1. 해당 영역을 벽으로 변경
        for i in select:
            arr[i[0]][i[1]] = 1
        # 2. 바이러스를 퍼트린다.
        for v in virus:
            bfs(v[0],v[1],arr)
        # 3. 안전영역을 갱신한다.
        cnt = count_safety(arr)
        max_cnt = max_cnt if max_cnt > cnt else cnt
    else:
        for i in cand:
            if visited[i[0]][i[1]] == True: continue
            select[k] = i
            visited[i[0]][i[1]] = True
            rec_func(k+1)
            select[k] = 0
            visited[i[0]][i[1]] = False


rec_func(0)
print(max_cnt)