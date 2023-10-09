# 2천만 = 1초 , 백만 = 4MB
# N개의 부품, 각 부품에 정수 형태의 고유 번호.
# M개 종류의 부품 대량 구매 M개의 종류가 다 있는가?
N = int(input())  # 백만
A = list(map(int, input().split()))
M = int(input())  # 백만
B = list(map(int, input().split()))

# B를 순회하면서 A에 존재하는지 확인 존재 -> yes 없으면 no
# 순회탐색시 하나백 백만번 -> 10^12 시간초과
# 이진탐색 : logN 1000이 약 10 -> 백만 -> 20 B를 순회한다 해도 2천만 -> 1초

A.sort()


def binary_search(array: list, target: int, start: int, end: int) -> bool:
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return False


for num in B:
    if binary_search(A, num, 0, N - 1):
        print("yes", end=" ")
    else:
        print("no", end=" ")


# -------------------계수 정렬------------
N = int(input())
arr = [0] * (1000001)

for i in input().split():
    arr[int(i)] = 1

M = int(input())
x = list(map(int, input().split()))

for i in x:
    if arr[i] == 1:
        print("yes", end=" ")
    else:
        print("no", end=" ")
