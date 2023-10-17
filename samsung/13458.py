# N개의 시험장, i번 시험장에는 Ai명의 응시자
# 총 감독관 = B명 감시 가능, 부감독관 = C명 감시 가능
# 총 감독관은 시험장마다 1명만, 부감독관은 제한 없다.
# 모든 응시자들을 감시하기위해 필요한 감독관 수의 최솟값

N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())

ans = N
for i in range(N):
    A[i] = 0 if B >= A[i] else A[i] - B
cnt = 0

for num in A:
    if num == 0: continue
    a, b = divmod(num, C)
    if b == 0:
        cnt += a
    else:
        cnt += a + 1

print(ans+cnt)