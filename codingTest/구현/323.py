# 문자열 재정렬
# 알파벳 대문자와 숫자 0~9로만 이루어진 문자열
# 모든 알파벳을 오름차순으로 정렬한 뒤 그 뒤에 숫자를 더한 값을 이어서 출렧하라
# KIKA5CB7 -> ABCKK13

S = input()

string = ""
num = 0

for word in S:
    if word.isdigit():
        num += int(word)
    else:
        string += word

string = sorted(string)
print("".join(string) + str(num))
