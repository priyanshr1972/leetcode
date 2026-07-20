class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        feq = [0] * (len(nums))
        for i in range(0,len(nums)):
            feq[nums[i]]+=1
        for i in range(len(feq)):
            if feq[i]>1:
                return i    
        return -1

        