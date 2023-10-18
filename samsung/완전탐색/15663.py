N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

selected = [0 for _ in range(M)]
used = [0 for _ in range(N+1)]

def rec_func(k):
    if k == M:
        for x in selected:
            print(x, end=" ")
        print()
    else:
        last_cand = 0
        for cand in range(N):
            if used[cand] or last_cand == nums[cand]:
                continue
            last_cand = nums[cand]
            selected[k] = nums[cand]
            used[cand] = 1

            rec_func(k+1)

            selected[k] = 0
            used[cand] = 0

rec_func(0)