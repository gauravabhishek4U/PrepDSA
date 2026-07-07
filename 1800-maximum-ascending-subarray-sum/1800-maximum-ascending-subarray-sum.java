class Solution {
    public int maxAscendingSum(int[] nums) {
        int high = 1, currSum = nums[0], maxSum = Integer.MIN_VALUE;

        while(high < nums.length){
            if(nums[high] > nums[high-1]){
                currSum += nums[high];
            }
            else{
                maxSum = Math.max(maxSum, currSum);
                currSum = nums[high];
            }
            high++;
        }
        return Math.max(maxSum, currSum);
    }
}