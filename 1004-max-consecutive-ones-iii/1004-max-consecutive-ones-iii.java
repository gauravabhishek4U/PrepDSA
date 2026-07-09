class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int zeros=0;
        int maxCount = 0;

// Approach 1 : counting no of zeros by managing a zero counter
// TC : more than O(N) but lesser than O(N^2)
        for(end = 0; end < nums.length; end++){
            if(nums[end] == 0){
                zeros++;
            }
            if(zeros>k){
                if(nums[start] == 0){
                    zeros--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end-start+1);
        }
        return maxCount;
    }
}