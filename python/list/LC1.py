nums = [2, 7, 11, 15]
target = 9


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        l = len(nums)

        for i in range(l-1):
            for j in range(i+1, l):
                if nums[i] + nums[j] == target:
                    return [nums[i], nums[j]]

    def twoSum(self, nums: list[int], target: int) -> list[int]:
        for i, n in enumerate(nums):
            complement = target - n

            if complement in nums[i+1:]:
                return [nums.index(n), nums[i+1:].index(complement) + (i + 1)]

    def twoSum(self, nums: list[int], target: int) -> list[int]:
        nums_map = {}
        for i, num in enumerate(nums):
            nums_map[num] = i

        for i, num in enumerate(nums):
            if target - num in nums_map and i !=nums_map[target-num]:
                return [i, nums_map[target - num]]

    def twoSum(self, nums: list[int], target: int) -> list[int]:
        nums_map = {}
        for i, num in enumerate(nums):
            if target - num in nums_map:
                return [nums_map[target-num], i]
            nums_map[num] = i
