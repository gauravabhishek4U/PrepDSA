/*
Approach : Prefix and Suffix product 
TC = o(n)
SC = O(n)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // nums = [1,2,3,4], so n = 4
        int[] ans = new int[n]; // ans = [_,_,_,_]

        // prefix product of the leftmost element will always be 1
        ans[0] = 1; // ans = [1,_,_,_]

        // calculating the prefix product from left side
        for(int i=1; i<n; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        // ans = [1, 1, 2, 6] 

        // suffix product of the rightmost element will always be 1
        int rightProd = 1;

        // calculating the suffix product from right side
        for(int r = n-1; r >=0; r--){
            ans[r] = ans[r] * rightProd;
            rightProd = rightProd * nums[r];
        }

        // rightProd = 1, ans = [1,1,2,6], rightProd updated to 1 * 4 = 4
        // rightProd = 4, ans = [1,1,8,6], rightProd updated to 4 * 3 = 12
        // rightProd = 12, ans = [1,12,8,6], rightProd updated to 12 * 2 = 24
        // rightProd = 24, ans = [24,12,8,6], rightProd updated to 24 * 1 = 24

        return ans; // final ans = [24, 12, 8, 6]
    }
}