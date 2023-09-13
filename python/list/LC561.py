# 짝수개의 nums, n쌍의 숫자 (a,b)... 중 min(a,b)들의 합이 최대가 되는 경우의 최대합

class Solution:
    def arrayPairSum(self, nums: list[int]) -> int:
        nums.sort()
        answer = 0
        for i in range(0,len(nums),2):
            answer += nums[i]

        return answer
