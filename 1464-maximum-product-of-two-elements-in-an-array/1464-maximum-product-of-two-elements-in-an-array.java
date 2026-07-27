class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i = 0; i< n; i++){
            for(int j = i+1; j<n; j++){
                int prod = (nums[i]-1) * (nums[j]-1);
                ans = Math.max(ans, prod);
            }
        }
        return ans;
    }
}