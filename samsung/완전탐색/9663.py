N = int(input())

column = [0 for _ in range(N)]
cnt = 0

def attackable(r1,c1,r2,c2):
    if c1 == c2:
        return True
    if (r1+c1) == (r2+c2):
        return True
    if (r1-c1) == (r2-c2):
        return True
    return False

def rec_func(k):
    global cnt
    if k == N:
        # 모든 row에 퀸을 놓았다.
        cnt += 1
    else:
        for cand in range(N):
            # 놓을 칼럼의 후보
            possible = True
            for i in range(k):
                if attackable(k, cand, i, column[i]):
                    possible = False
                    break
            if possible:
                column[k] = cand
                rec_func(k+1)
                column[k] = 0


rec_func(0)

print(cnt)