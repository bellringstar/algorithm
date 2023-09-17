import sys

input = sys.stdin.readline

# 1. 절단기 높이 H 지정. -> 연속 나무 한줄 절단
# ex) H보다 큰 나무는 H 위의 부분이 잘린다. 낮은 나무는 안잘린다.
# 20, 15, 10, 17, H=15 => 15,15,10,15, 5+2 만큼 가져간다.
# 10 15 17 20
# 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 최소 높이의 최대값
# 정렬 후 H보다 큰 것들 x개 => 큰것들 합 - H * x >= M 정담
# 4 26 40 42 46 => ex 26 => 4 26 26 26 26 (M = 50 > 20)
# 4 26 40 42 46 => ex 40 => 4 26 40 40 40 (M = 8 < 20)
# 따라서 H 는 26과 40 사이 M이 20이 되는 순간을 찾자
# 40 +42 +46 - 3*x>=20 -> x>=36
# 이진탐색 4 26 40 42 46 ->
# mid 이후의 것들의 합 - 개수 * mid값 => M보다 크다 -> left = mid +1

N, M = map(int, input().split())
heights = sorted(list(map(int, input().split())))

left, right = 0, heights[-1]
res = 0

while left <= right:
    mid = (left + right) // 2
    sum_height = sum([h - mid for h in heights if h > mid])

    if sum_height >= M:
        res = mid
        left = mid + 1
    else:
        right = mid - 1

print(res)
