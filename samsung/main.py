# 2차원 정사각형 행렬 90도 회전
def rotate_90(arr):
    N = len(arr)
    ret = [[0] * N for _ in range(N)]

    for r in range(N):
        for c in range(N):
            ret[c][N-1-r] = arr[r][c]
    return ret

arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(rotate_90(arr))