// TC = O(N), SC = O(1)

class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        // edge case for size 1
        if (n == 1) return nums[0];

        int maxProduct = Integer.MIN_VALUE, currMax = 1, currMin = 1;

        for( int num : nums){
            if (num < 0){ // handling the negative element
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(num, num * currMax);
            currMin = Math.min(num, num * currMin);
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }
}