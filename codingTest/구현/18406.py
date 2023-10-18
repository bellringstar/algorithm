N = input()
length = len(N)
left = N[: length // 2]
right = N[length // 2 :]

if sum(map(int, left)) == sum(map(int, right)):
    print("LUCKY")
else:
    print("READY")
