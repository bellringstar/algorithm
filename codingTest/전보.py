# C에서 출발하여 모든 점들의 최단경로, 최단경로들의 최대
import heapq

N, M, C = map(int, input().split())
INF = int(1e9)

graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)
distance[C] = 0
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijstra(start):
    q = []
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijstra(C)

arr = [i for i in distance if i != INF]

print(len(arr), max(arr))
