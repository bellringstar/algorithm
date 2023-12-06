import sys
input = sys.stdin.readline

N, M = map(int, input().split())

money = [int(input()) for _ in range(N)]

def is_possible(m):
    cnt = 1
    sum = 0
    for i in range(N):
        if sum + money[i] <= m:
            sum += money[i]
        else:
            cnt += 1
            sum = money[i]
    return cnt <= M

L = max(money)
R = int(1e9)
ans = 0
while L <= R:
    mid = (L + R) // 2
    if is_possible(mid):
       ans = mid
       R = mid - 1
    else:
        L = mid + 1

print(ans)
