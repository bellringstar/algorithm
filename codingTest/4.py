# N이 1이 될 때까지
# 1. N에서 1을 뺸다. 2. N을 K로 나눈다(나누어 떨어질때만)
# N = 17, K = 4 -> 16 -> 4 -> 1 최소 횟수 3
# 어차피 나눗셈이 가능하다면 그게 가장 이득이다.

N, K = map(int, input().split())

count: int = 0
while N != 1:
    if N % K == 0:
        N /= K
    else:
        N -= 1  # N이 커지면 비효율적 K의 배수가 될때까지 x번 빼도록 수정하는게 이득
    count += 1

print(count)
