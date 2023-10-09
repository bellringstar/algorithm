# 2천만 1초 백만 4MB
# 절단기 높이 H
# 19, 14, 10, 17,  H = 15  -> 15, 14, 10, 15/ 잘린 떡 : 4, 0, 0, 2
# 즉 손님은 6cm의 길이를 가져간다.
# 손님이 M을 요청했을 때 적어도 M만큼 떡을 얻기 위해 H의 최대값
# H가 높아진다 -> 잘리는 부분이 적어진다

# 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 -> 파라메트릭 서치

N, M = map(int, input().split())  # N: 1~백만, M: 1 ~ 20억
height = list(map(int, input().split()))  # 0~10억

start = 0
end = max(height)

rst = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    for h in height:
        if h > mid:
            total += h - mid
    if total < M:
        end = mid - 1
    else:
        rst = mid  # 일단 기록 후 최대값을 위해 이동
        start = mid + 1

print(rst)
