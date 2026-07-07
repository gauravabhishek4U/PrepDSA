class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int j = 0, maxCount = Integer.MIN_VALUE, currCount = 0;

// OPTIMAL APPROACH : count the no of 1's unless a 0 is encountered, and compare the existing count with the maximum count found so far
        while(j < n){
            if(nums[j] == 1){
                currCount++;
            }
            else{
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }
            j++;
        }
        return Math.max(maxCount, currCount);
    }
}