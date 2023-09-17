import sys

input = sys.stdin.readline

# C개의 공유기를 N개의 집에 인접 거리 D가 최대가 되게 할 때 D
# 이진탐색을 통해 D를 결정 가능 -> res 갱신, M 증가 -> L = M + 1
N, C = map(int, input().split())  # N<2*10^5 C <= N

homes = sorted([int(input()) for _ in range(N)])

left, right = 1, homes[-1]


def possible(d: int, c: int) -> bool:
    # 거리가 d로, c개가 배치가 가능한가?
    cnt = 1  # 첫 위치는 무조건 설치
    curr_idx = 0
    for i in range(1, N):
        if homes[i] - homes[curr_idx] >= d:
            cnt += 1
            curr_idx = i
            if cnt == c:
                return True
    return False


res = 1
while left <= right:
    mid = (left + right) // 2
    if possible(mid, C):
        res = mid
        left = mid + 1
    else:
        right = mid - 1


print(res)
