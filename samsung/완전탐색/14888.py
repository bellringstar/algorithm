N = int(input())
nums = list(map(int, input().split()))
operators = list(map(int, input().split()))


def calc(num1, op, num2):
    if op == 0:
        return num1 + num2
    if op == 1:
        return num1 - num2
    if op == 2:
        return num1 * num2
    if op == 3:
        if num1 < 0:
            return -((-num1) // num2)
        else:
            return num1 // num2

max = -int(1e9)
min = int(1e9)
def rec_func(k, value):
    global max, min
    if k == N-1:
        max = max if max > value else value
        min = min if min < value else value
    else:
        for i in range(4):
            if operators[i] > 0:
                operators[i] -= 1
                op = i
                rec_func(k+1, calc(value, op, nums[k+1]))
                operators[i] += 1



rec_func(0, nums[0])
print(max)
print(min)