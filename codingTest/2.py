# 큰 수의 법칙
# M번 더해 가장 큰 수를 만들자 , 단 특정 인덱스가 연속해서 K번을 초과할 수 없다.

N, M, K = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort(reverse=True)

a, b = divmod(M, K + 1)  # 몫, 나머지

answer = a * (nums[0] * K + nums[1]) + b * nums[0]

print(answer)
