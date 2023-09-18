import sys
input = sys.stdin.readline

# N개의 단어, 길이가 짧은것부터, 길이가 같으면 사전순으로, 중복된 단어 없이
# N < 2*10^4  N^2 = 4*10^8 => 시간초과
N = int(input())
lst = list(set(input().rstrip() for _ in range(N)))

lst.sort(key = lambda x : (len(x), x))

for word in lst:
    print(word)

#------------------------------------

n = int(input())
a = []
for i in range(n):
    a.append(input().strip())

a.sort(key = lambda x: (len(x), x))

for i in range(n):
    if i == 0 or a[i] != a[i-1]:
        print(a[i])