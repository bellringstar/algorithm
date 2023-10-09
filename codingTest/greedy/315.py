# A, B 두 사람이 볼링을 친다.
# 총 N개의 볼링공, 1번~N번 무게는 1~M 서로 다른 무게
N, M = map(int, input().split())
data = list(map(int, input().split()))

cnt = 0
for i in range(N-1):
    a = data[i]
    for j in range(i+1, N):
        b = data[j]
        if a != b :
            cnt +=1

print(cnt)

n, m = map(int, input().split())
data = list(map(int, input().split()))

array = [0] * 11

for x in data:
    array[x] += 1

result = 0
for i in range(1, m+1):
    n -= array[i]
    result += array[i] * n

print(result)