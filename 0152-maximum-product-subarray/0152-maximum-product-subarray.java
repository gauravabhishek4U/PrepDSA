// Approach :: using Prefix and Suffix Product
// TC = O(N), SC = O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // edge case for size 1
        if (n == 1) return nums[0];

        int prefixProd = 1, suffixProd = 1;
        int maxProduct = nums[0];

        for(int i=0; i<n; i++){
            prefixProd *= nums[i];
            suffixProd *= nums[n-i-1];

            maxProduct = Math.max(maxProduct, Math.max(prefixProd, suffixProd));

            if(prefixProd == 0) prefixProd = 1;
            if(suffixProd == 0) suffixProd = 1; 
        }
        return maxProduct;
    }
}    


/*
// Approach :: Using Kadane's Algo
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

*/