# 확장자별로 정리해서 개수 세기, 확장자들을 사전순으로 정렬

import sys
from collections import Counter
input = sys.stdin.readline

N = int(input())
a = [input().strip().split('.')[1] for _ in range(N)]

c = Counter(a)

answer = []

for key,value in c.items():
    answer.append((key, value))

answer.sort(key=lambda x : x[0])

for t in answer:
    print(*t)

#--------------------------------------

n = int(input())

ext = []
for _ in range(n):
    ext.append(input().strip().split(".")[1])

ext.sort()

i = 0
while i < n:
    cnt = 1
    for j in range(i+1, n):
        if ext[j] == ext[i]:
            cnt += 1
            i += 1
        else:
            break
    print(ext[i], cnt)
    i += 1