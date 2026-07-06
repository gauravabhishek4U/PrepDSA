class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0, sum = 0;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        while(high < n){
            // add the new element in the window from high end
            sum += nums[high];
            
            while(sum >= target){
                int size = high-low+1;
                result = Math.min(result, size);
                // remove the first element from the existing window from left end
                sum -= nums[low];
                low++;
            }
            high++;
        }
        // if result is equal to MAX_VALUE, return 0 as it means no minimum subarray condition was satisfied, else return the calculated answer
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}