# N개의 집, M개의 길(양방향)
# 마을을 2개의 분리된 마을로 분할할 계획.
# 각 마을안에 집들이 서로 연결되도록
# 크루스칼 알고리즘 : 최소신장트리
# 일단 최소신장트리로 만들고 가장 비용이 큰 도로의 연결을 끊는다.

N, M = map(int, input().split())

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

result = 0
last = 0
edges = []
parent = [0] * (N+1)
for i in range(1,N+1):
    parent[i] = i

for _ in range(M):
    A, B, C = map(int, input().split()) # A 와 B 사이 길 유지비 C
    edges.append((C, A, B))

edges.sort() #비용이 가장 저렴한 순으로 정렬

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        last = cost

print(result - last)



