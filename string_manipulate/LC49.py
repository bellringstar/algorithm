# 문자열 어레이가 주어졌을 때 아나그램을 묶어라=> 정렬됐을 때 같은 것들을 묶는다
from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        d = defaultdict(list)
        for word in strs:
            key = "".join(sorted(word))
            d[key].append(word)
        answer = []
        for value in d.values():
            answer.append(value)
        return answer

    # --------------------------------------------------------------------
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        anagrams = defaultdict(list)

        for word in strs:
            anagrams["".join(sorted(word))].append(word)
        return list(anagrams.values())
