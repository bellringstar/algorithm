# 문자열 뒤집기
# 0와 1로만 이루어진 문자열 S. S를 전부 같은 수로 만들려고한다.
# 1. S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는다.

S = input()

count0 = 0 #전부 0으로
count1 = 0 #전부 1으로

if S[0] == '1':
    count0 += 1
else:
    count1 += 1

for i in range(len(S) - 1):
    if S[i] != S[i+1]:
        if S[i+1] == '1':
            count0 += 1
        else:
            count1 += 1
print(min(count0, count1))