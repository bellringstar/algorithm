from collections import Counter
import re

# banned 이 아닌 가장 많이 나온 단어


class Solution:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:
        for c in paragraph:
            if not c.isalnum():
                paragraph = paragraph.replace(c, " ")
        words = paragraph.split()
        banned = [w.lower() for w in banned]
        lst = [word.lower() for word in words if word.lower() not in banned]
        c = Counter(lst)
        answer = c.most_common(1)
        return answer[0][0]

    # ----------------------------------------------
    def mostCommonWord2(self, paragraph: str, banned: list[str]) -> str:
        words = [
            word
            for word in re.sub(r"[^\w]", " ", paragraph).lower().split()
            if word not in banned
        ]

        counts = Counter(words)
        return counts.most_common(1)[0][0]
