# 자기보다 작은 것의 개수
# 1. A 하나당 B를 순회하며 체크 -> 시간초과
# 2. B를 이진탐색으로 A1보다 작은것중 최대위치를 찾는다
import sys

input = sys.stdin.readline


def lower_bound(a, l, r, x):
    res = l - 1
    while l <= r:
        mid = (l + r) // 2
        if a[mid] < x:
            res = mid
            l = mid + 1
        else:
            r = mid - 1
    return res


def solve():
    b.sort()
    ans = 0
    for x in a:
        ans += lower_bound(b, 0, m - 1, x) + 1
    print(ans)


T = int(input())
for _ in range(T):
    n, m = list(map(int, input().split()))
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    solve()
