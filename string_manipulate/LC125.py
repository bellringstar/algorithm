class Solution:
    def isPalindrome(self, s: str) -> bool:
        lst = []
        for char in s:
            if char.isalnum():
                lst.append(char.lower())
        string = "".join(lst)
        return string == string[::-1]


s = Solution()
answer = s.isPalindrome("A man, a plan, a canal: Panama")
print(answer)
