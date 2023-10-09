# 신장트리 = 그래프에서 모든 노드를 포함하며 사이클이 없는 부분 그래프

# 최소 비용으로 만들 수 있는 신장트리를 찾느 알고리즘 = 크루스칼(그리디 알고리즘의 일종)
# O(ElogE)
# 모든 간선에 대하여 정렬을 수행한 뒤 가장 거리가 짧은 간선부터 집합에 포함시킨다.
# 이 때 사이클이 발생시킬 수 있는 간선의 경우 포함시키지 않는다.
# 비용을 오름차순 정렬 -> 사이클 발생 여부에 따라 트리에 포함 -> 반복


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


v, e = map(int, input().split())
parent = [0] * (v + 1)

edges = []
result = 0

for i in range(1, v + 1):
    parent[i] = i

for _ in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 연결
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
print(result)
