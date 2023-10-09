# 일직선상. 인접한 식량창고가 공격받으면 바로 안다.
# 정찰병들에게 들키기 않고 약탈하려면 최소 한칸 이상 떨어져있어야한다.
# [1, 3, 1, 5] -> 3+5 8이 최대

N = int(input())  # 3<=N<=100
nums = list(map(int, input().split()))

# 현재가 i번째일때 i-1번을 턴 경우와 i-2번을 턴 경우가 갈라진다.
# ai = max(ai-1, ai-2 + ki)

d = [0] * 100

d[0] = nums[0]
d[1] = max(nums[0], nums[1])
for i in range(2, N):
    d[i] = max(d[i - 1], d[i - 2] + nums[i])

print(d[N - 1])
