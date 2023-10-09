# N명의 모험가. 공포도가 X인 모험가는 반드시 X이상으로 구성한 모험가 그룹에 참가야해 한다. 최대 몇개의 모험가 그룹을 만들 수 있을까

N = int(input()) # 5
arr = list(map(int, input().split())) # 2 3 1 2 2

arr.sort()

result = 0
count = 0

for i in arr:
    count += 1
    if count >= i:
        result += 1
        count = 0
print(result)



