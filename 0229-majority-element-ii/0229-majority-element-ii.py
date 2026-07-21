class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        arr=[]
        size=(len(nums))//3
        print(size)
        hash={}
        for i in nums:
            hash[i]=1+hash.get(i,0)
        for i in hash:
            if hash[i]>size:
                arr.append(i)
        return arr
