import sys

input = sys.stdin.readline

# 산성 용액 1~ 10억 , 알칼리 용액 -1 ~ -10억
# 두 용액을 혼합하여 특성값이 0에 가까운 용액
# [-2, 4, -99, -1, 98] => -99+98 = -1
# 어떤 용액 A -> A+x = 0 => x = -A => -A에 가까운 용액을 찾는다.
# 가까운 수 => 정렬했을 때 해당 수와 가장 가까운 수는 그 수 양 옆이다.
# N = 10^5 => N^2은 시간초과

N = int(input())
nums = sorted(list(map(int, input().split())))

l, r = 0, N - 1
best_sum = 1e10
v1, v2 = 0, 0

while l < r:
    sum_value = nums[l] + nums[r]
    if abs(sum_value) < best_sum:
        best_sum = abs(sum_value)
        v1, v2 = nums[l], nums[r]
    if sum_value < 0:
        l += 1
    else:
        r -= 1


print(v1, v2)
