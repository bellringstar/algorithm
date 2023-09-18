# 색깔별로 나눠서 저장, a = (0,1) = (위치, 색깔), (1,2),(3,1)(4,2)(5,1)
# 1번색: [(0,1),(3,1),(5,1)] 2번색:[(1,2),(4,2)]
# 화살표는? 위치 기준 정렬, 가장 좌,우를 확인한다.
# 만약 좌나 우가 없다? 있는 쪽만 확인

import sys

input = sys.stdin.readline
answer = 0
N = int(input())
arr = [[] for _ in range(N + 1)]

for _ in range(N):
    a, b = map(int, input().split())
    arr[b].append(a)

for lst in arr:
    if lst:
        lst.sort()

for lst in arr:
    if not lst:
        continue
    for i in range(len(lst)):
        if i == 0:
            answer += lst[i + 1] - lst[i]
        elif i == len(lst) - 1:
            answer += lst[i] - lst[i - 1]
        else:
            l = min((lst[i] - lst[i - 1]), (lst[i + 1] - lst[i]))
            answer += l
print(answer)

# _----------------------------
n = int(input())

a = [[] for _ in range(n + 1)]

for i in range(n):
    coord, color = map(int, input().split())
    a[color].append(coord)


def toLeft(color, i):
    if i == 0:
        return 10000000
    return a[color][i] - a[color][i - 1]


def toRight(color, i):
    if i + 1 == len(a[color]):
        return 1000000
    return a[color][i + 1] - a[color][i]


ans = 0
for color in range(1, n + 1):
    a[color].sort()
    for i in range(len(a[color])):
        ans += min(toLeft(color, i), toRight(color, i))

print(ans)
