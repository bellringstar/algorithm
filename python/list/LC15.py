class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        # num[i], num[j], num[k] -> i,j,k가 다르다. 합이 0이다.
        nums.sort()
        answer = []
        for i in range(len(nums)):
            target = -nums[i]
            left, right = i + 1, len(nums) - 1
            while left < right:
                if nums[left] + nums[right] == target:
                    lst = [nums[i], nums[left], nums[right]]
                    if lst not in answer:
                        answer.append(lst)
                    left += 1
                    right -= 1
                elif nums[left] + nums[right] > target:
                    right -= 1
                else:
                    left += 1
        return answer
    #---------------------------------------------------------------
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        results = []
        nums.sort()

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            left, right = i + 1, len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] +nums[right]
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    results.append([nums[i], nums[left], nums[right]])

                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
        return results

