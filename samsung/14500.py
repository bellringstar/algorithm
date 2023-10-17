from collections import deque
N, M = map(int, input().split())
graph =[list(map(int, input().split())) for _ in range(N)]

max_value = -1
# dfs로는 ㅗ 모양을 표현할수없다. -> dfs 1회