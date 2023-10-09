# 1초, 128MB  2천만번 = 1초 백만개 = 4MB

# N x M 직사각형 육지 또는 바다. 동서남북을 바라보며 시작
# 해당 칸 = (A, B) = (행, 렬)
# 1. 현재 방향 기준으로 반시계로 차례로 갈 곳을 정한다. 총 4방향
# 2. 바로 왼쪽에 가보지 않은 칸 -> 그 방향으로 몸을 돌린 뒤 전진
# 3. 왼쪽 방향에 가보지 않은 칸이 없다 -> 다시 반시계 회전
# 요약하면 현재 방향에서 왼쪽으로 회전하며 갈수있냐 없냐를 판단
# 4방향을 다 확인했는데 갈 수 없다 -> 현재 방향 상태로 한칸 뒤로(반대방향으로) 후 다시 4방향 판단.
# 근데 뒤로 가는데 그곳이 바다라 이동할 수 없다? => 종료

N, M = map(int, input().split())
# 0: 북, 1: 동, 2: 남, 3: 서
r, c, d = map(int, input().split())  # 초기 위치, 초기 방향
graph = [list(map(int, input().split())) for _ in range(N)]  # 0육지 1바다

left = ((0, -1), (1, 0), (0, 1), (-1, 0))  # 북 서 남 동 기준 왼쪽
curr_d = d
rst = 1
count = 0
graph[r][c] = 2
while True:
    if count == 4:
        # 모든 방향 확인 완료 뒤로 돌아가자
        r += left[(curr_d + 1) % 4][0]
        c += left[(curr_d + 1) % 4][1]
        if graph[r][c] == 1:
            break
        count = 0
    new_r = r + left[(curr_d) % 4][0]
    new_c = c + left[(curr_d) % 4][1]
    if new_r < 0 or new_r >= N or new_c < 0 or new_c >= N:
        curr_d += 1
        count += 1
        continue
    if graph[new_r][new_c] == 1 or graph[new_r][new_c] == 2:
        curr_d += 1
        count += 1
        continue
    if graph[new_r][new_c] == 0:
        graph[new_r][new_c] = 2  # 갔던 곳 표시
        rst += 1
        r, c = new_r, new_c
        curr_d += 1
        count = 0


print(rst)
