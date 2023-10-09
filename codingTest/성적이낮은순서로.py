N = int(input())

data = [input().split() for _ in range(N)]

data.sort(key=lambda x: x[1])

for i in data:
    print(i[0], end=" ")
