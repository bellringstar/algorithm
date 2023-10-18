N, S = map(int, input().split())
nums = list(map(int, input().split()))
ans = 0

def rec_func(k, value):
    if k == N:
        global ans
        if value == S:
            ans += 1
    else:
        rec_func(k+1, value+nums[k])
        rec_func(k+1, value)

rec_func(0, 0)

if S == 0:
    ans -= 1
print(ans)