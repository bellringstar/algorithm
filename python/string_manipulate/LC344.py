class Solution:
    def reverseString(self, s: list[str]) -> None:
        """
        Do not return anything, modify s in-place instead. O(1) extra memory
        """
        length = len(s)
        for i in range(length // 2):
            s[i], s[length - i - 1] = s[length - i - 1], s[i]


a = Solution()
s = ["h", "e", "l", "l", "o"]
a.reverseString(s)
