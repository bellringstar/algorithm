# 1초 128MB  2천만번 = 1초 , 백만개 = 4MB
# 8x8 좌표 평면. 나이트는 L모양으로만 이동 가능
# 수평으로 두칸 이동 뒤 수직으로 한칸 / 수직으로 두칸이동 뒤 수평으로 한칸
# 1~8행, a~h열, 나이트가 이동할 수 있는 경우의 수
# 결국 현재 좌표에서 이동했는데 범위 내인가?

p = input()
col_dic = {}
c = "a"
for idx, i in enumerate(range(8)):
    col_dic[c] = i
    c = chr(ord(c) + 1)


r = int(p[1]) - 1
c = col_dic[p[0]]

d = ((2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (-1, 2), (1, -2), (-1, -2))

cnt = 0
for delta in d:
    new_r = r + delta[0]
    new_c = c + delta[1]
    if 0 <= new_r < 8 and 0 <= new_c < 8:
        cnt += 1

print(cnt)
