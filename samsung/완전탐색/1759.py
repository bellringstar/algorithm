L, C = map(int, input().split())
words = input().split()

words.sort()
selected = [0 for _ in range(L)]

def is_vowel(c):
    return c in {'a','e','i','o','u'}

def rec_func(k):
    if k == L:
        vowel, consonant = 0,0
        for x in selected:
            if is_vowel(words[x]):
                vowel += 1
            else:
                consonant += 1
        if vowel >=1 and consonant>=2:
            for x in selected:
                print(words[x], end='')
            print()
    else:
        start = -1 if k == 0 else selected[k-1]
        for i in range(start+1, C):
            selected[k] = i
            rec_func(k+1)
            selected[k] = 0

rec_func(0)


