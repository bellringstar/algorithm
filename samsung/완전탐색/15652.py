N, M = map(int, input().split())

selected = [0 for _ in range(M)]

def rec_func(k):
    if k == M:
        for x in selected:
            print(x, end=" ")
        print()
    else:
        start = 1 if k==0 else selected[k-1]
        for cand in range(start, N+1):
            selected[k] = cand
            rec_func(k+1)
            selected[k] = 0

rec_func(0)