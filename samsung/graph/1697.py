from collections import deque

N, K = map(int, input().split())

dist = [-1] * (100001)

def bfs(v):
    q = deque()
    q.append(v)
    dist[v] = 0

    while q:
        now = q.popleft()
        for dr in (-1, 1, now):
            new_pos = now + dr
            if new_pos < 0 or new_pos > 100000 or dist[new_pos] != -1:
                continue
            dist[new_pos] = dist[now] + 1
            q.append(new_pos)

bfs(N)
print(dist[K])