class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int low = 0, prod = 1, high = 0, count = 0;

        while(high < n){
            prod *= nums[high];
            // increase the window from the right end
            high++;
            while(prod >= k){
                // remove the first index from the window from left end
                prod = prod/nums[low];
                low++;
            }
            // accumulating subarrays in windows 
            count += high-low;
        
        }
        return count;
    }
}