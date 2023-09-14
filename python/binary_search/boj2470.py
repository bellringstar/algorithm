import sys

input = sys.stdin.readline

# 산성: 1~ 10억 양의 정수 알칼리성: -1 ~ -10억 : int범위
# 합해서 0에 가까운 용액
# [-2,4,-99,-1,98] => -99 + 98 = -1 => 0에 가장 가깝다
# 숫자를 하나씩 돌면서 합이 0에 가까운 수를 찾는다 => 가까운수? = 정렬
# a랑 합이 0이다 = -a => -a에 가장 가까운 정수를 찾기


# ----------------
def lower_bound(a, l, r, x):
    res = r + 1
    while l <= r:
        mid = (l + r) // 2
        if a[mid] >= x:
            res = mid
            r = mid - 1
        else:
            l = mid + 1
    return res


n = int(input())
a = sorted(list(map(int, input().split())))
best_sum = 1 << 31
v1, v2 = 0, 0
for l in range(n - 1):
    cand = lower_bound(a, l + 1, n - 1, -a[l])
    if l < cand - 1 and abs(a[l] + a[cand - 1]) < best_sum:
        best_sum = abs(a[l] + a[cand - 1])
        v1, v2 = a[l], a[cand - 1]
    if cand < n and abs(a[l] + a[cand]) < best_sum:
        best_sum = abs(a[l] + a[cand])
        v1, v2 = a[l], a[cand]

print(v1, v2)
