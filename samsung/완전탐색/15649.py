N, M = map(int, input().split())

selected = [0 for _ in range(M)]
used = [False for _ in range(N+1)]

def rec_func(k):
    if k == M:
        for x in selected:
            print(x, end=" ")
        print()
    else:
        for cand in range(1, N+1):
            if used[cand]:
                continue
            selected[k] = cand
            used[cand] = True
            rec_func(k+1)
            selected[k] = 0
            used[cand] = False

rec_func(0)