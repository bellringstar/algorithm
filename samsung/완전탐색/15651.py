N, M = map(int, input().split())

selected = [0 for _ in range(M)]

def rec_func(k):
    if k == M:
        for x in selected:
            print(x, end= " ")
        print()
    else:
        for cand in range(1, N+1):
            selected[k] = cand
            rec_func(k+1)
            selected[k] = 0

            