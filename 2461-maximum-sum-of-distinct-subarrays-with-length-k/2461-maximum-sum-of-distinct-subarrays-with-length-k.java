class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        long maxSum = 0, currSum = 0;

        Map <Integer, Integer> mpp = new HashMap<>();

        for(int right = 0; right < n; right++){
            // add the current element in the window sum
            currSum += nums[right];
            mpp.put(nums[right], mpp.getOrDefault(nums[right],0)+1);

            // if size of window exceeds K
            //shrink the window by removing one element from left
            // calculate the new sum and increase the left pointer
            if(right - left + 1 > k ){
                mpp.put(nums[left], mpp.get(nums[left])-1);
                if(mpp.get(nums[left]) == 0){
                    mpp.remove(nums[left]);
                }
                currSum -= nums[left];
                left++;
            }

            // if window size is valid (equals to K)
            if(right-left+1 == k && mpp.size()==k){
                maxSum = Math.max(maxSum,currSum);
            }
        }
        return maxSum;
        
    }
}