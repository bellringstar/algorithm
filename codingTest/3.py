# 가장 높은 숫자의 카드 뽑기
# NXM 카드 배열 1. 행선택 2. 행에서 가장 낮은 숫자 카드를 뽑는다.
# 즉 행에서 가장 작은 수가 제일 큰 행을 고르는 문제

N, M = map(int, input().split())

nums = [list(map(int, input().split())) for _ in range(N)]

max_value = 0

# NxM 계산 -> 최대 10^4 N^2 여유

for r in nums:
    max_value = max(max_value, min(r))

print(max_value)
