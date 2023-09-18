# 문자열 s가 주어졌을 때 가장 긴 팰린드롬 문자열을 반환하세요
# s의 길이는 1000이하 => n^2 =  10^6 시간적으로 여유
def is_palindrome(s: str) -> bool:
    return s == s[::-1]


class Solution:
    def longestPalindrome(self, s: str) -> str:
        answer = ""
        for i in range(len(s)):
            for j in range(i, len(s) + 1):
                target = s[i:j]
                if is_palindrome(target):
                    if len(target) > len(answer):
                        answer = target
        return answer

    # --------------------시간 10초----------------------------------
    def longestPalindrome(self, s: str) -> str:
        def expand(left: int, right: int) -> str:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1 : right]

        if len(s) < 2 or s == s[::-1]:
            return s

        result = ""
        for i in range(len(s) - 1):
            result = max(result, expand(i, i + 1), expand(i, i + 2), key=len)
        return result
