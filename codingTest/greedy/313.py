# S = 0~9로만 이루어진 문자열
# 왼쪽부터. 하나씩 수를 확인하며 숫자 사이에 x 혹은 + 연산자를 넣어 만들어질 수 있는 가장 큰수
# 0과 1이 아니면 곱이 유리. 0과 1일때는 합이 유리

S = input()
rst = int(S[0])

for i in range(1, len(S)):
    if S[i-1] == '0' or S[i-1] == '1':
        rst += int(S[i])
    else:
        rst *= int(S[i])

print(rst)
