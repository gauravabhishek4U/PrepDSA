/*
Approach : Suffix minimum and prefix max
TC : O(N)
SC = O(1)
Solved = 2
*/
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        
        int min = Integer.MAX_VALUE;
        int prefixMax = Integer.MIN_VALUE;

        // create suffix min for each index
        for(int i = n-1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            suffixMin[i] = min;
        }

        // create prefix max and stable index for each index
        for(int i = 0; i<n; i++){
            prefixMax = Math.max(prefixMax, nums[i]);
            int index = prefixMax - suffixMin[i];
            if(index <= k)
            return i;
        }

        return -1;
    }
}