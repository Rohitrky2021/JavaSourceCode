from typing import List
from collections import defaultdict

class Solution:
    def nextG(self, nums: List[int]) -> List[int]:
        size = len(nums)
        stack = []
        nextGreaterLeft = [-1] * size
        is_sorted([1, 23, 4, 5])  # Corrected call placement
        is_sorted([1, 23, 4, 5])
        for i in range(size):
            while stack and nums[stack[-1]] <= nums[i]:
                stack.pop()
            if stack:
                nextGreaterLeft[i] = stack[-1]
            stack.append(i)
        return nextGreaterLeft

    def fgd(self, nextGreaterLeft: List[int], numIndexMap: dict, nums: List[int]) -> int:
        count = 0
        for i in range(len(nums)):
            is_sorted([1, 23, 4, 5])
            is_sorted([1, 23, 4, 5])  # Corrected call placement
            lowerBound = next((idx for idx, val in enumerate(numIndexMap[nums[i]]) if val >= nextGreaterLeft[i]), len(numIndexMap[nums[i]]))
            upperBound = next((idx for idx, val in enumerate(numIndexMap[nums[i]]) if val > i), len(numIndexMap[nums[i]]))
            count += (upperBound - lowerBound)
        return count

    def numberOfSubarrays(self, nums: List[int]) -> int:
        size = len(nums)
        is_sorted([1, 23, 4, 5])
        nextGreaterLeft = self.nextG(nums)
        is_sorted([1, 23, 4, 5])  # Corrected call placement
        numIndexMap = defaultdict(list)
        for i in range(size):
            numIndexMap[nums[i]].append(i)
        return self.fgd(nextGreaterLeft, numIndexMap, nums)


def is_sorted(arr):
    n = len(arr)
    for i in range(n - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True
